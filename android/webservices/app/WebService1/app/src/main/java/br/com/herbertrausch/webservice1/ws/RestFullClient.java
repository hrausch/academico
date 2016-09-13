package br.com.herbertrausch.webservice1.ws;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import br.com.herbertrausch.webservice1.model.Pessoa;

/**
 * Created by Herbert on 12/12/2014.
 */
public class RestFullClient {

    public static final int OPERACAO_RECUPERAR = 1;
    public static final int OPERACAO_SALVAR = 2;

    //Endereco do servidor do Web Service
    private String BASE_URL_WS = "http://200.128.152.122:8090/pessoa";



    private HttpClient httpClient;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse response;

    public RestFullClient(){
        // instancia um cliente http
        httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");
    }


    /**
     * Este metodo realiza uma chamada ao servico que busca em um banco de dados
     * todas as pessoas cadastradas e retorna uma lista desses objetos
     * @return
     */
    public ArrayList<Pessoa> recuperarPessoas(){

        StringBuilder builder = new StringBuilder();
        ArrayList<Pessoa> result = new ArrayList<Pessoa>();

        httpGet = new HttpGet();
        httpGet.setHeader("Content-Type", "text/plain; charset=utf-8");

        //atribue a url do servico
        try {
            httpGet.setURI(new URI(BASE_URL_WS));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {

            // executa o servico
            response = httpClient.execute(httpGet);

            /*
            * recupera o status da chamada ao servico.
            * se o status for 200 significa que foi recuerado com sucesso e sera realizado o tratamento
            * do JSON recebido
            * A lista de codigos e os significado de cada um deles pode ser encontrado em (http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html)
            * */
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {

                //recupera o conteudo do pacote HTTP recebido
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                content.close();

                /**
                 * Atraves da string recuperada do servico que possui o objeto JSON, realiza o
                 * parser desse objeto transformando a String em um ArrayList
                 */
                result = JSONFile(builder.toString());

            }
            else {
                Log.e("WS", "Erro ao realizar a operacao" + statusCode);

            }
        } catch (ClientProtocolException e) {
            Log.e("WS", e.toString());

        } catch (IOException e) {
            Log.e("WS", e.toString());
        }

        return result;

    }


    /**
     * Este servico chama um Web Service que requer a passagem de 2 parametros via POST
     * Os parametros do SERVICO sao nome_pessoa e telefone_pessoa
     * @param nomePessoa
     * @param telefonePessoa
     */
   public void salvarPessoa(String nomePessoa, String telefonePessoa){

       httpPost = new HttpPost(BASE_URL_WS);

       // O servico INSERIR_PESSOA recebe dois parametros via POST
       List<NameValuePair> params = new ArrayList<NameValuePair>();
       params.add(new BasicNameValuePair("nome", nomePessoa));

       try {

           Gson gson = new Gson();
           String json = gson.toJson(e);
           StringEntity input = new StringEntity(json);

           input.setContentType("application/json");

           httpPost.setEntity(input);

           httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

       } catch (UnsupportedEncodingException e) {
           Log.e("WS",e.toString());
       }

       try {

           // executa o servico
           response = httpClient.execute(httpPost);

            /*
            * recupera o status da chamada ao servico.
            * se o status for 200 significa que foi recuerado com sucesso e sera realizado o tratamento
            * do JSON recebido
            * A lista de codigos e os significado de cada um deles pode ser encontrado em (http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html)
            * */
           StatusLine statusLine = response.getStatusLine();
           int statusCode = statusLine.getStatusCode();
           if (statusCode == 200) {
               return;
           }

       } catch (IOException e) {
           Log.e("WS",e.toString());
       }

   }


    /**
     * Este metodo recebe um string no formato JSON com os objetos Pessoa retornado pelo Web service
     * Realiza o "parser" dessa string transformando-a em uma lista de Pessoas
     * @param stringJason
     * @return
     */
   private ArrayList<Pessoa> JSONFile(String stringJason){

        ArrayList<Pessoa> result = new ArrayList<Pessoa>();

        try{

            //nativo do SDK  da o parse da string json
            JSONObject object = (JSONObject) new JSONTokener(stringJason).nextValue();

            // monta o array do retorno do json, lembrando que retorno é o PAI do json impresso
            //{"list":[ {"campo1":"valor1"},{"campo2":"valor2"},{"campo3":"valor3"} ]}
            JSONArray message = object.getJSONArray("list");

            //Percorre o array retornado
            for(int i=0;i<message.length();i++){
                JSONObject lines = (JSONObject) new JSONTokener(message.getString(i)).nextValue();

                Pessoa objPessoa = new Pessoa();

                objPessoa.setNome(lines.getString("nome"));
                objPessoa.setTelefone(lines.getString("telefone"));
                objPessoa.setIdade( Integer.parseInt(lines.getString("idade")));

                result.add(objPessoa);

            }

        }catch (Exception e) {
            Log.e("WS",e.toString());
        }

        return result;
    }





}



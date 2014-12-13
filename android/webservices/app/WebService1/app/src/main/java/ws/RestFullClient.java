package ws;

import android.os.AsyncTask;
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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herbert on 12/12/2014.
 */
public class RestFullClient {

    private String BASE_URL_WS = "http://192.168.0.6/webservice1/recuperar.php";


  /*  public static void main(String args[]){




        System.out.println("main do client");

        String retorno = new RestFullClient().testeGet();
        System.out.println(retorno);

    }*/

    public String testePos(){
        String content = "";
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");

        HttpPost httpPost = new HttpPost(BASE_URL_WS);
// Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("nome", "Bob"));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // writing error to Log
            e.printStackTrace();
        }
/*
 * Execute the HTTP Request
 */
        try {
            Log.i("WS", "POST");
            HttpResponse response = httpClient.execute(httpPost);
            Log.i("WS", "POST 2");
            HttpEntity respEntity = response.getEntity();

            if (respEntity != null) {
                // EntityUtils to get the response content
                content =  EntityUtils.toString(respEntity);
                System.out.println(content);
                return content;
            }
        } catch (ClientProtocolException e) {
            // writing exception to log
            e.printStackTrace();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();
        }
        return content;
    }

    public String testeGet(){

        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");

        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("Content-Type", "text/plain; charset=utf-8");
        try {
            httpGet.setURI(new URI(BASE_URL_WS));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {

            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();

            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {

                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

            } else {
                Log.e("WS", "Teste Get erro");

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("WS", e.toString());
        }
        return builder.toString();
    }

}



package br.com.herbertrf.list.model;

/**
 * Created by hrausch on 17/06/16.
 */
import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Endereco implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private double[] localizacao;

    private String rua;
    private String estado;
    private String cidade;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Recebe um json que representa um objeto e o transforma em Object
     * @param objectJson
     * @return
     */
    public static Endereco fromJson(String objectJson) {
        Gson gson = new Gson();
        Endereco e = gson.fromJson(objectJson, Endereco.class);
        return e;
    }

    /**
     * Recebe um json que representa uma lista de objetos e retorna em ArrayList<>
     * @param objectJson
     * @return
     */
    public static ArrayList<Endereco> fromArrayJson(String objectJson) {
        Gson gson = new Gson();
        ArrayList<Endereco> e = new ArrayList<Endereco>();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(objectJson).getAsJsonArray();

        int tamanho = array.size();
        for (int i = 0; i < tamanho; i++) {

            Endereco endereco = gson.fromJson(array.get(i), Endereco.class);
            e.add(endereco);
        }

        return e;
    }

}

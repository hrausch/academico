package br.cefetmg.sqllite.model;



import java.io.Serializable;


public class Endereco implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;



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




}

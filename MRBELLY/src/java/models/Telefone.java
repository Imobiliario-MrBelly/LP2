package models;

public class Telefone {

    private String ddd;
    private String numero;
    private String descricao;

    public Telefone(String ddd, String numero, String descricao) {
        this.ddd = ddd;
        this.numero = numero;
        this.descricao = descricao;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

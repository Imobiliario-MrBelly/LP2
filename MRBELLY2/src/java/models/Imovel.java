package models;

public abstract class Imovel {

    private Endereco endereco;
    private double area;
    private String descricao;
    private double condominio;
    private double iptu;

    public Imovel(Endereco endereco, double area, String descricao, double condominio, double iptu) {
        this.endereco = endereco;
        this.area = area;
        this.descricao = descricao;
        this.condominio = condominio;
        this.iptu = iptu;
    }

    public double getIptu() {
        return iptu;
    }

    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCondominio() {
        return condominio;
    }

    public void setCondominio(double condominio) {
        this.condominio = condominio;
    }
}

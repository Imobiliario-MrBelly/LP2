package models;

public abstract class Imovel {
    private int id ;
    private Endereco endereco;
    private double area;
    private String descricao;
    private double condominio;
    private double iptu;
    private Locador locador;

    public Imovel(Endereco endereco, double area, String descricao, double condominio, double iptu,Locador locador) {
        this.endereco = endereco;
        this.area = area;
        this.descricao = descricao;
        this.condominio = condominio;
        this.iptu = iptu;
        this.locador=locador;
    }

    public Imovel(int id, Endereco endereco, double area, String descricao, double condominio, double iptu,Locador locador) {
        this.id = id;
        this.endereco = endereco;
        this.area = area;
        this.descricao = descricao;
        this.condominio = condominio;
        this.iptu = iptu;
         this.locador=locador;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

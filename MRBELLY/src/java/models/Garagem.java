package models;

public class Garagem extends Imovel{
    int id;
    private int tamanho;
    private boolean coberturaChuva;
    private String localizacao;

    public Garagem(int tamanho, boolean coberturaChuva, String localizacao, Endereco endereco, double area, String descricao, double condominio, double iptu,Locador locador) {
        super(endereco, area, descricao, condominio, iptu, locador);
     
        this.tamanho = tamanho;
        this.coberturaChuva = coberturaChuva;
        this.localizacao = localizacao;
    }
public int getId(){
    return id;
}
    public boolean isCoberturaChuva() {
        return coberturaChuva;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean getCoberturaChuva() {
        return coberturaChuva;
    }

    public void setCoberturaChuva(boolean coberturaChuva) {
        this.coberturaChuva = coberturaChuva;
    }
}

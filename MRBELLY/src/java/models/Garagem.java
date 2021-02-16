package models;

public class Garagem extends Imovel{
    private int tamanho;
    private boolean coberturaChuva;
    private String localizacao;

    public Garagem(int tamanho, boolean coberturaChuva, String localizacao, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(endereco, area, descricao, condominio, iptu);
        this.tamanho = tamanho;
        this.coberturaChuva = coberturaChuva;
        this.localizacao = localizacao;
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

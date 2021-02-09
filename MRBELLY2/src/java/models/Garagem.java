package models;

public class Garagem extends Imovel{
    private int tamanho;
    private boolean coberturaChuva;
    private int localizacao;

    public Garagem(int tamanho, boolean coberturaChuva, int localizacao, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(endereco, area, descricao, condominio, iptu);
        this.tamanho = tamanho;
        this.coberturaChuva = coberturaChuva;
        this.localizacao = localizacao;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isCoberturaChuva() {
        return coberturaChuva;
    }

    public void setCoberturaChuva(boolean coberturaChuva) {
        this.coberturaChuva = coberturaChuva;
    }
}

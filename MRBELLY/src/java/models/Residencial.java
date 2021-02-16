package models;

public abstract class Residencial extends Imovel {

    private int qtdQuartos;
    private int qtdSalas;
    private int qtdCozinhas;
    private int qtdBanheiros;
    private int vagasGaragem;

    public Residencial(int qtdQuartos, int qtdSalas, int qtdCozinhas, int qtdBanheiros, int vagasGaragem, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(endereco, area, descricao, condominio, iptu);
        this.qtdQuartos = qtdQuartos;
        this.qtdSalas = qtdSalas;
        this.qtdCozinhas = qtdCozinhas;
        this.qtdBanheiros = qtdBanheiros;
        this.vagasGaragem = vagasGaragem;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public int getQtdQuartos() {
        return qtdQuartos;
    }

    public void setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public int getQtdSalas() {
        return qtdSalas;
    }

    public void setQtdSalas(int qtdSalas) {
        this.qtdSalas = qtdSalas;
    }

    public int getQtdCozinhas() {
        return qtdCozinhas;
    }

    public void setQtdCozinhas(int qtdCozinhas) {
        this.qtdCozinhas = qtdCozinhas;
    }

    public int getQtdBanheiros() {
        return qtdBanheiros;
    }

    public void setQtdBanheiros(int qtdBanheiros) {
        this.qtdBanheiros = qtdBanheiros;
    }
}

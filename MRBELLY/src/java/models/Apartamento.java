package models;

public class Apartamento extends Residencial{
    private int andar;
    private boolean elevador;

    public Apartamento(int andar, boolean elevador, int qtdQuartos, int qtdSalas, int qtdCozinhas, int qtdBanheiros, int vagasGaragem, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(qtdQuartos, qtdSalas, qtdCozinhas, qtdBanheiros, vagasGaragem, endereco, area, descricao, condominio, iptu);
        this.andar = andar;
        this.elevador = elevador;
    }

    public boolean isElevador() {
        return elevador;
    }

    public void setElevador(boolean elevador) {
        this.elevador = elevador;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
}

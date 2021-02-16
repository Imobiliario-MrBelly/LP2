package models;

public class Comercial extends Imovel{
    private int vagasGaragem;
    private int sobreLoja;

    public Comercial(int vagasGaragem, int sobreLoja, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(endereco, area, descricao, condominio, iptu);
        this.vagasGaragem = vagasGaragem;
        this.sobreLoja = sobreLoja;
    }

    public int getSobreLoja() {
        return sobreLoja;
    }

    public void setSobreLoja(int sobreLoja) {
        this.sobreLoja = sobreLoja;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }
    
    
}

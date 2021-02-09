package models;

public class Comercial extends Imovel{
    private int vagasGaragem;
    private boolean sobreLoja;

    public Comercial(int vagasGaragem, boolean sobreLoja, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(endereco, area, descricao, condominio, iptu);
        this.vagasGaragem = vagasGaragem;
        this.sobreLoja = sobreLoja;
    }

    public boolean isSobreLoja() {
        return sobreLoja;
    }

    public void setSobreLoja(boolean sobreLoja) {
        this.sobreLoja = sobreLoja;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }
    
    
}

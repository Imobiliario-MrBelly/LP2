package models;

public class Casa extends Residencial{

    private double areaCoberta;
    private double areaDescoberta;

    public Casa(double areaCoberta, double areaDescoberta, int qtdQuartos, int qtdSalas, int qtdCozinhas, int qtdBanheiros, int vagasGaragem, Endereco endereco, double area, String descricao, double condominio, double iptu) {
        super(qtdQuartos, qtdSalas, qtdCozinhas, qtdBanheiros, vagasGaragem, endereco, area, descricao, condominio, iptu);
        this.areaCoberta = areaCoberta;
        this.areaDescoberta = areaDescoberta;
    }

    public double getAreaDescoberta() {
        return areaDescoberta;
    }

    public void setAreaDescoberta(double areaDescoberta) {
        this.areaDescoberta = areaDescoberta;
    }

    public double getAreaCoberta() {
        return areaCoberta;
    }

    public void setAreaCoberta(double areaCoberta) {
        this.areaCoberta = areaCoberta;
    }
}

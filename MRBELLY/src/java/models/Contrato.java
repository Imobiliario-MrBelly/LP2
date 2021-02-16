package models;

import java.util.Date;

public class Contrato {
    private Date dataInicio;
    private Date dataFim;
    private double valor;
    private Pessoa fiador;
    private Imovel imovel;
    private Locador locador;
    private Locatario locatario;

    public Contrato(Date dataInicio, Date dataFim, double valor, Imovel imovel, Locador locador, Locatario locatario) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.imovel = imovel;
        this.locador = locador;
        this.locatario = locatario;
    }

    public Contrato(Date dataInicio, Date dataFim, double valor, Pessoa fiador, Imovel imovel, Locador locador, Locatario locatario) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.fiador = fiador;
        this.imovel = imovel;
        this.locador = locador;
        this.locatario = locatario;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getFiador() {
        return fiador;
    }

    public void setFiador(Pessoa fiador) {
        this.fiador = fiador;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }
}

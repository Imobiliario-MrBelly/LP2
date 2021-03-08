package models;

import dao.ContratoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Contrato {

    private int id;
    private Imovel imovel;
    private Locatario locatario;
    private Date dataInicio;
    private Date dataFim;
    private double valor;

    public Contrato(int id, Imovel imovel, Locatario locatario, Date dataInicio, Date dataFim, double valor) {
        this.id = id;
        this.imovel = imovel;
        this.locatario = locatario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public Contrato(Imovel imovel, Locatario locatario, Date dataInicio, Date dataFim, double valor) {
        this.imovel = imovel;
        this.locatario = locatario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
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

    
    public static List<Contrato> obterContratos() throws SQLException, ClassNotFoundException {
        return ContratoDAO.getInstancia().obterContratos();
    }
    public static Contrato obterContrato(int id) throws SQLException, ClassNotFoundException{
        return ContratoDAO.getInstancia().obterContrato(id);
    }
}

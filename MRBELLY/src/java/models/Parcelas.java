package models;

import dao.ParcelasDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Parcelas {

   private int id;
   private int parcelas;
   private Date dataVencimento;
   private String banco;
   private String agencia;
   private String conta;

    public Parcelas(int id, int parcelas, Date dataVencimento, String banco, String agencia, String conta) {
        this.id = id;
        this.parcelas = parcelas;
        this.dataVencimento = dataVencimento;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
   public static List<Parcelas> obterParcelas()throws SQLException, ClassNotFoundException{
       return ParcelasDAO.getInstancia().obterParcelas();
   }
   public static Parcelas obterParcela(int id )throws SQLException, ClassNotFoundException{
       return ParcelasDAO.getInstancia().obterParcela(id);
   }
   
}

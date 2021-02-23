package models;

import dao.ParcelasDAO;
import java.util.Date;

public class Parcelas {
   private int parcelas;
   private Date dataVencimento;
   private String banco;
   private String agencia;
   private String conta;

    public Parcelas(int parcelas, Date dataVencimento, String banco, String agencia, String conta) {
        this.parcelas = parcelas;
        this.dataVencimento = dataVencimento;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
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
   public static List<Parcelas> obterParcelas(){
       return ParcelasDAO.getInstancia().obterParcelas();
   }
   
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Parcelas;

public class ParcelasDAO extends DAO{
    
    static private ParcelasDAO instancia = new ParcelasDAO();
    
    public static ParcelasDAO getInstancia(){
    return instancia;
    }

    public void gravar(Parcelas p)throws SQLException,ClassNotFoundException,
            CloneNotSupportedException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO PARCELAS(parcelas, dataVencimento, banco, agencia, conta) VALUES (?,?,?,?,?);");

            comando.setInt(1, p.getParcelas());
            comando.setDate(2, (Date) p.getDataVencimento());
            comando.setString(3, p.getBanco());
            comando.setString(4, p.getAgencia());
            comando.setString(5, p.getConta());
            comando.executeUpdate();

        } finally{
            fecharConexao(conexao,comando);
        }
    }
    
    public boolean alterar(Parcelas p) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            
            comando = conexao.prepareStatement("UPDATE PARCELAS SET parcelas=?, dataVencimento=?,  banco=?, agencia=?, conta=? WHERE id=?;");
            
            comando.setInt(1, p.getParcelas());
            comando.setDate(2, (Date) p.getDataVencimento());
            comando.setString(3, p.getBanco());
            comando.setString(4, p.getAgencia());
            comando.setString(6, p.getConta());
            
            return comando.executeUpdate() > 0;
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public boolean excluir(Parcelas p) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            
            comando = conexao.prepareStatement("DELETE FROM casa WHERE id=?;");
            
            comando.setInt(1, p.getId());
            return comando.executeUpdate() > 0;
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public Parcelas obterParcela(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        
        Parcelas p = null;
        try {
            conexao = BD.getInstancia().getConexao();
            
            comando = conexao.prepareStatement("SELECT * FROM casa WHERE id=?;");
            
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();
            int nome = resultado.getInt("parcelas");
            Date sobrenome = resultado.getDate("dataVencimento");
            String banco = resultado.getString("banco");
            String agencia = resultado.getString("agencia");
            Date conta = resultado.getDate("conta");

            return p;
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
     public List<Parcelas> obterParcelas() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        
        Parcelas p = null;
        List<Parcelas> parcela = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            
            comando = conexao.prepareStatement("SELECT * FROM casa;");
            
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                
                int id = resultado.getInt("id");
                int parcelas = resultado.getInt("parcelas");
                Date dataVencimento = resultado.getDate("dataVencimento");
                String banco = resultado.getString("bacno");
                String agencia = resultado.getString("agencia");
                String conta = resultado.getString("conta");
                parcela.add(p);
                
            }
            
            return parcela;
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}

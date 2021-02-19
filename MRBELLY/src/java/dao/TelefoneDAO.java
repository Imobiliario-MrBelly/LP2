package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Telefone;

public class TelefoneDAO {
    
    static private TelefoneDAO instancia = new TelefoneDAO();
    
    static TelefoneDAO getInstacia(){
        return instancia;
    }
    
    public void gravar(Telefone telefone) throws SQLException,ClassNotFoundException, CloneNotSupportedException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try {
            conexao = BD.getInstancia().getConexao();
            
            comando  = conexao.prepareStatement("INSERT INTO TELEFONE(numero, ddd, descrição)");
            
            comando.setString(1, telefone.getNome());
            comando.setString(2, telefone.getSobrenome());
            comando.setString(3, telefone.getRg());
            comando.setString(4, telefone.getCpf());
            comando.setDate(5, (Date) telefone.getNascimento());
            comando.setBoolean(6, telefone.isSexo());
            TelefoneDAO.
            comando.setString(7, telefone.getTelefone());
            comando.setDate(8, x);
            
            
        } finally{
            
        }
    }

}

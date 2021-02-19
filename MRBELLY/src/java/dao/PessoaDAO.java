package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Pessoa;

public class PessoaDAO extends DAO {
    
    static private PessoaDAO instancia = new PessoaDAO();
    
    static PessoaDAO getInstancia(){
        return instancia;
    }
    
    public void gravar(Pessoa pessoa) throws SQLException,ClassNotFoundException, CloneNotSupportedException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try {
            conexao = BD.getInstancia().getConexao();
            
            comando  = conexao.prepareStatement("INSERT INTO PESSOA(nome, dataCadastro, flag");
            comando.setString(1, pessoa.);
        } finally{
            
        }
    }
    
    

}

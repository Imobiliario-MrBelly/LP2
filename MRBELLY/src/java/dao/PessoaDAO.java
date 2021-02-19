package dao;

import java.sql.Connection;
import java.sql.Date;
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
            
            comando  = conexao.prepareStatement("INSERT INTO PESSOA(nome, sobrenome, rg, cpf, nascimento, sexo, telefone, dataCadastro");
            
            comando.setString(1, pessoa.getNome());
            comando.setString(2, pessoa.getSobrenome());
            comando.setString(3, pessoa.getRg());
            comando.setString(4, pessoa.getCpf());
            comando.setDate(5, (Date) pessoa.getNascimento());
            comando.setBoolean(6, pessoa.isSexo());
            TelefoneDAO.
            comando.setString(7, pessoa.getTelefone());
            comando.setDate(8, x);
            
            
        } finally{
            
        }
    }
    
    

}

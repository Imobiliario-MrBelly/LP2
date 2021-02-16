package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import models.Imovel;
public class ImovelDAO extends DAO {
    private static  ImovelDAO instancia = new ImovelDAO();
    public static ImovelDAO getInstancia(){
        return instancia;
    }
    public void gravar (Imovel imovel) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("insert into imovel (idIMOVEL, tamanho,condominio, iptu, descricao, endereco) values (?,?,?,?,?,?)");
            comando.setNull(1, Types.INTEGER);
            comando.setDouble(2, imovel.getArea());
            comando.setDouble(3,imovel.getCondominio());
            comando.setDouble(4, imovel.getIptu());
            comando.setNString(5, imovel.getDescricao());
            comando.setInt(6, imovel.getEndereco().getId());
            comando.executeUpdate();
            
            
        }finally{
            fecharConexao(conexao,comando);
        }
    }
    public void alterar (Imovel imovel) throws SQLException, ClassNotFoundException{
       Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstancia().getConexao();
            comando=conexao.prepareStatement("updadate imovel (idIMOVEL,tamanho,condominio,iptu,descricao,endereco)values (?,?,?,?,?,?) ");
            comando.setInt(1,imovel.getId());
            comando.setDouble(2, imovel.getArea());
            comando.setDouble(3,imovel.getCondominio());
            comando.setDouble(4, imovel.getIptu());
            comando.setNString(5, imovel.getDescricao());
            comando.setInt(6, imovel.getEndereco().getId());
            comando.execute();
            
        }finally{
             fecharConexao(conexao,comando);
        }}
    
        public void excluir (Imovel imovel ){
            Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao=BD.getInstancia().getConexao();
            comando=conexao.prepareStatement("delete from imovel where idIMOVEL == ?");
            comando.setInt(1, imovel.getId());
            EnderecoDao = 
        }
        }
        
    }
    


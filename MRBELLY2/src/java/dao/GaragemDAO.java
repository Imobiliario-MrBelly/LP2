package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Garagem;

public class GaragemDAO extends DAO {
    private static GaragemDAO instancia = new GaragemDAO();
    public static GaragemDAO getInstancia(){
        return instancia;
    }
    private GaragemDAO(){
        
    }
    public void gravar (Garagem garagem)throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("insert into garagem (idGARAGEM,coberturaChuva,localizacao,imovel) values (?,?,?,?)");
            comando.setBoolean(2,garagem.getCoberturaChuva());
            comando.setString(3,garagem.getLocalizacao());
            comando.setInt(4,new ImovelDao().ler(garagem.super()));
            
            
        }catch{
            
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Garagem;
import models.Garagem;
import models.Imovel;

public class GaragemDAO extends DAO {
    private static GaragemDAO instancia = new GaragemDAO();
    public static GaragemDAO getInstancia(){
        return instancia;
    }
   
    public void gravar (Garagem garagem)throws SQLException,ClassNotFoundException, CloneNotSupportedException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("insert into garagem (tamanho, cobertura,localizacao,imovel) values (?,?,?,?)");
            comando.setInt(1, garagem.getTamanho());
            comando.setBoolean(2,garagem.getCoberturaChuva());
            comando.setString(3, garagem.getLocalizacao());
            comando.setInt(4, garagem.getImovel().getId());
            comando.executeUpdate();
            
            
        }finally{
            fecharConexao(conexao, comando);
        }
    }
    
      public boolean alterar(Garagem garagem) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE garagem SET tamanho=?, cobertura=?, localizacao=? WHERE id=?;");
            comando.setInt(1, garagem.getTamanho());
            comando.setBoolean(2, garagem.getCoberturaChuva());
            comando.setString(3, garagem.getLocalizacao());
            comando.setInt(4, garagem.getId());
           
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Garagem garagem) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM garagem WHERE id=?;");
            comando.setInt(1, garagem.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Garagem obterGaragem(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Garagem garagem = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM garagem WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            return instanciaGaragem(resultado);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Garagem> obterGaragens() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Garagem garagem = null;
        List<Garagem> garagens = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM garagem;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
             
                garagem = instanciaGaragem(resultado);
                garagens.add(garagem);
            }
            return garagens;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public Garagem instanciaGaragem(ResultSet resultado) throws SQLException, ClassNotFoundException{
        Garagem garagem = null;
        int id = resultado.getInt("id");
        int tamanho = resultado.getInt("tamanho");
        boolean cobertura = resultado.getBoolean("cobertura");
        String localizacao = resultado.getNString("localizacao");
        Imovel imovel = ImovelDAO.getInstancia().obterImovel(resultado.getInt("imovel"));
        return new Garagem(tamanho, cobertura, localizacao, imovel.getEndereco(), imovel.getArea(), imovel.getDescricao(), imovel.getCondominio(), imovel.getIptu(), imovel.getLocador());
    }
}

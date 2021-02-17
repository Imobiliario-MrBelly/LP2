package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Endereco;

import models.Imovel;
import models.Locador;

public class ImovelDAO extends DAO {

    private static ImovelDAO instancia = new ImovelDAO();

    public static ImovelDAO getInstancia() {
        return instancia;
    }

    public void gravar(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("INSERT INTO imovel (tamanho, "
                    + "descricao, iptu, condomino, endereco,locador) VALUES "
                    + "(?,?,?,?,?,?);");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setDouble(3, imovel.getIptu());
            comando.setDouble(4, imovel.getCondominio());
            comando.setInt(5, imovel.getEndereco().getId());
            comando.setInt(6, imovel.getLocador().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE imovel SET tamanho=?, descricao=?, iptu=?, condominio=?, endereco=? ,locador=? WHERE id=?;");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setDouble(3, imovel.getIptu());
            comando.setDouble(4, imovel.getCondominio());
            comando.setInt(5, imovel.getEndereco().getId());
            comando.setInt(6, imovel.getLocador().getId());
            comando.setInt(7, imovel.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM imovel WHERE id=?;");
            comando.setInt(1, imovel.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Imovel obterImovel(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Imovel imovel = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM imovel WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();
            imovel = instaciaImovel(resultado);
                  
            
        } finally {
            fecharConexao(conexao, comando);
        }return imovel;
    }

    public List<Imovel> obterImoveis() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Imovel imovel = null;
        List<Imovel> imoveis = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM imovel");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                imovel = instanciaImovel(resultado);
                imoveis.add(imovel);
            }
           
        } finally {
            fecharConexao(conexao, comando);
        }
         return imoveis;
    }
    public Imovel instanciaImovel(ResultSet resultado) throws SQLException, ClassNotFoundException{
         double iptu=resultado.getDouble("iptu");
         int id = resultado.getInt("id");
            double condominio=resultado.getDouble("condominio");
            double area=resultado.getDouble("tamanho");
            String descricao=resultado.getNString("descricao");
            Endereco endereco = EnderecoDAO.getInstancia().obterEndereco(resultado.getInt("endereco"));
            Locador locador = LocadorDAO.getInstancia().obterLocador(resultado.getInt("locador"));
            Imovel imovel = new Imovel(id, endereco, area, descricao, condominio, iptu, locador);   
        return imovel;
    }

    private Imovel instaciaImovel(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

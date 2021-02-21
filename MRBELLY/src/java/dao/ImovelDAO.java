package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Endereco;

import models.Imovel;
import models.Locador;

public class ImovelDAO extends DAO {

    private static final ImovelDAO instancia = new ImovelDAO();

    public static ImovelDAO getInstancia() {
        return instancia;
    }

    public void gravar(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("INSERT INTO imovel (tamanho, "
                    + "descricao,garagem ,iptu, condomino, endereco,locador) VALUES "
                    + "(?,?,?,?,?,?);");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setInt(3, imovel.getGaragem());
            comando.setDouble(4, imovel.getIptu());
            comando.setDouble(5, imovel.getCondominio());
            comando.setInt(6, imovel.getEndereco().getId());
            comando.setInt(7, imovel.getLocador().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
       

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE imovel SET tamanho=?, descricao=?, iptu=?, condominio=?, endereco=? ,locador=?,garagem=? WHERE id=?;");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setDouble(3, imovel.getIptu());
            comando.setDouble(4, imovel.getCondominio());
            comando.setInt(5, imovel.getEndereco().getId());
            comando.setInt(6, imovel.getLocador().getId());
            comando.setInt(7, imovel.getGaragem());
            comando.setInt(8, imovel.getId());
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
            imovel = instanciaImovel(resultado);
                  
            
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
         int garagem = resultado.getInt("garagem");
            double condominio=resultado.getDouble("condominio");
            double area=resultado.getDouble("tamanho");
            String descricao=resultado.getNString("descricao");
            Endereco endereco = EnderecoDAO.getInstancia().obterEndereco(resultado.getInt("endereco"));
            Locador locador = LocadorDAO.getInstancia().obterLocador(resultado.getInt("locador"));
            Imovel imovel = new Imovel(id, endereco, area, descricao, condominio, iptu, garagem, locador) {
            }
            
        return imovel;
    }

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            conexao.setAutoCommit(false);
            
            
            comando = conexao.prepareStatement("INSERT INTO endereco (rua, numero, cep, cidade, uf) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, imovel.getEndereco().getRua());
            comando.setString(2, imovel.getEndereco().getNumero());
            comando.setString(3, imovel.getEndereco().getCep());
            comando.setString(4, imovel.getEndereco().getCidade());
            comando.setString(5, imovel.getEndereco().getUf());
            comando.executeUpdate();
            
            
            ResultSet rs = comando.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            imovel.getEndereco().setId(id);
            comando = conexao.prepareStatement("INSERT INTO imovel (area, "
                    + "descricao,garagem ,iptu, condominio, endereco,locador) VALUES "
                    + "(?,?,?,?,?,?,?);");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setInt(3, imovel.getGaragem());
            comando.setDouble(4, imovel.getIptu());
            comando.setDouble(5, imovel.getCondominio());
            comando.setInt(6, imovel.getEndereco().getId());
            comando.setInt(7, imovel.getLocador().getId());
            comando.executeUpdate();
            conexao.commit();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement("UPDATE endereco SET rua=?, numero=?, cep=?, cidade=?, uf=? WHERE id=?;");
            comando.setString(1, imovel.getEndereco().getRua());
            comando.setString(2, imovel.getEndereco().getNumero());
            comando.setString(3, imovel.getEndereco().getCep());
            comando.setString(4, imovel.getEndereco().getCidade());
            comando.setString(5, imovel.getEndereco().getUf());
            comando.setInt(6, imovel.getEndereco().getId());
            comando.executeUpdate();
            
            comando = conexao.prepareStatement("UPDATE imovel SET area=?, descricao=?, iptu=?, condominio=?, endereco=? ,locador=?,garagem=? WHERE id=?;");
            comando.setDouble(1, imovel.getArea());
            comando.setString(2, imovel.getDescricao());
            comando.setDouble(3, imovel.getIptu());
            comando.setDouble(4, imovel.getCondominio());
            comando.setInt(5, imovel.getEndereco().getId());
            comando.setInt(6, imovel.getLocador().getId());
            comando.setInt(7, imovel.getGaragem());
            comando.setInt(8, imovel.getId());
            comando.executeUpdate();
            
            
           
             
             conexao.commit();
             return true;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Imovel imovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            EnderecoDAO.getInstancia().excluir(imovel.getEndereco());
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

            while (resultado.next()) {
                imovel = instanciaImovel(resultado);
            }
            return imovel;
        } finally {
            fecharConexao(conexao, comando);
        }

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
            return imoveis;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public Imovel instanciaImovel(ResultSet resultado) throws SQLException, ClassNotFoundException {
        int id = resultado.getInt("id");
        int garagem = resultado.getInt("garagem");
        double condominio = resultado.getDouble("condominio");
        double area = resultado.getDouble("area");
        String descricao = resultado.getNString("descricao");
        double iptu = resultado.getDouble("iptu");

        Endereco endereco = EnderecoDAO.getInstancia().obterEndereco(resultado.getInt("endereco"));
        Locador locador = LocadorDAO.getInstancia().obterLocador(resultado.getInt("locador"));
        Imovel imovel = new Imovel(id, endereco, area, descricao, condominio, iptu, garagem, locador) {
        };

        return imovel;
    }

}

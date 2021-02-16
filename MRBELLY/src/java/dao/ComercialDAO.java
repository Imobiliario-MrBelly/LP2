package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Comercial;

public class ComercialDAO extends DAO {

    private static ComercialDAO instancia = new ComercialDAO();

    public static ComercialDAO getInstancia() {
        return instancia;
    }

    public void gravar(Comercial comercial) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO comercial (garagem, sobreLoja, imovel_id) VALUES (?,?,?);");
            comando.setInt(1, comercial.getVagasGaragem());
            comando.setInt(2, comercial.getSobreLoja());
            comando.setInt(3, 0/*tem que mexer aqui quando as classes ficarem prontas*/);
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Comercial comercial) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE comercial SET garagem=?, sobreLoja=? WHERE id=?;");
            comando.setInt(1, comercial.getVagasGaragem());
            comando.setInt(2, comercial.getSobreLoja());
            comando.setInt(3, comercial.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);

            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Comercial comercial) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM comercial WHERE id=?;");
            comando.setInt(1, comercial.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Comercial obterComercial(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Comercial comercial = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM comercial WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();
            int vagasGaragem = resultado.getInt("garagem");
            int sobreLoja = resultado.getInt("sobreLoja");

            //comercial = new Comercial(...)
            return comercial;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Comercial> obterComerciais() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Comercial comercial = null;
        List<Comercial> comerciais = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM comercial;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int vagasGaragem = resultado.getInt("garagem");
                int sobreLoja = resultado.getInt("sobreLoja");

                //comercial = new Comercial(...)
                comerciais.add(comercial);
            }
            return comerciais;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

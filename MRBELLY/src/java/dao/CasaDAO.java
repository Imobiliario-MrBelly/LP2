package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Casa;

public class CasaDAO extends DAO {

    private static CasaDAO instancia = new CasaDAO();

    public static CasaDAO getInstancia() {
        return instancia;
    }

    public void gravar(Casa casa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO casa (areaCoberta, areaDescoberta, residencial_id) VALUES (?,?,?);");
            comando.setDouble(1, casa.getAreaCoberta());
            comando.setDouble(2, casa.getAreaDescoberta());
            comando.setInt(3, 0/*tem que mexer aqui quando as classes ficarem prontas*/);
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Casa casa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE casa SET areaCoberta=?, areaDescoberta=? WHERE id=?;");
            comando.setDouble(1, casa.getAreaCoberta());
            comando.setDouble(2, casa.getAreaDescoberta());
            comando.setInt(3, casa.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);

            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Casa casa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM casa WHERE id=?;");
            comando.setInt(1, casa.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Casa obterCasa(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Casa casa = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM casa WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();
            double areaCoberta = resultado.getDouble("areaCoberta");
            double areaDescoberta = resultado.getDouble("areaDescoberta");

            //casa = new Casa(...)
            return casa;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Casa> obterCasas() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Casa casa = null;
        List<Casa> casas = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM casa;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                double areaCoberta = resultado.getDouble("areaCoberta");
                double areaDescoberta = resultado.getDouble("areaDescoberta");

                //casa = new Casa(...);
                casas.add(casa);
            }
            return casas;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

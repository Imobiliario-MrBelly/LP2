package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Apartamento;

public class ApartamentoDAO extends DAO {

    private static ApartamentoDAO instancia = new ApartamentoDAO();

    public static ApartamentoDAO getInstancia() {
        return instancia;
    }

    public void gravar(Apartamento apartamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO apartamento (andar, elevador, residencial_id) VALUES (?,?,?);");
            comando.setInt(1, apartamento.getAndar());
            comando.setInt(2, apartamento.getElevador());
            comando.setInt(3, 0/*tem que mexer aqui quando as classes ficarem prontas*/);
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Apartamento apartamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE apartamento SET andar=?, elevador=? WHERE id=?;");
            comando.setDouble(1, apartamento.getAndar());
            comando.setDouble(2, apartamento.getElevador());
            comando.setInt(3, apartamento.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);

            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Apartamento apartamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM apartamento WHERE id=?;");
            comando.setInt(1, apartamento.getId()/*tem que mexer aqui quando as classes ficarem prontas*/);
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Apartamento obterApartamento(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Apartamento apartamento = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM apartamento WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();
            int andar = resultado.getInt("andar");
            int elevador = resultado.getInt("elevador");

            //apartamento = new Apartamento(...)
            return apartamento;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Apartamento> obterApartamentos() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Apartamento apartamento = null;
        List<Apartamento> apartamentos = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM apartamento;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int andar = resultado.getInt("andar");
                int elevador = resultado.getInt("elevador");

                //apartamento = new Apartamento(...)
                apartamentos.add(apartamento);
            }
            return apartamentos;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

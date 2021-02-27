package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Contrato;

public class ContratoDAO extends DAO {

    private static ContratoDAO instancia = new ContratoDAO();

    public static ContratoDAO getInstancia() {
        return instancia;
    }

    public void gravar(Contrato contrato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO contrato (dataInicio, periodo, valor, imovel, locatario) VALUES (?,?,?,?,?);");
            comando.setDate(1, (Date) contrato.getDataInicio());
            comando.setInt(2, contrato.getPeriodo());
            comando.setDouble(3, contrato.getValor());
            comando.setInt(4, contrato.getImovel().getId());
            comando.setInt(5, contrato.getLocatario().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Contrato contrato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE contrato SET dataInicio=?, dataTermino=?, valor=?, imovel=?, locatario=? WHERE id=?;");
            comando.setDate(1, (Date) contrato.getDataInicio());
            comando.setDate(2, (Date) contrato.getDataFim());
            comando.setDouble(3, contrato.getValor());
            comando.setInt(4, contrato.getImovel().getId());
            comando.setInt(5, contrato.getLocatario().getId());
            comando.setInt(6, contrato.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Contrato contrato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM contrato WHERE id=?;");
            comando.setInt(1, contrato.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Contrato obterContrato(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Contrato contrato = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM contrato WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();

            Date dataInicio = resultado.getDate("dataInicio");
            Date dataFim = resultado.getDate("dataTermino");
            double valor = resultado.getDouble("valor");
            int imovel = resultado.getInt("imovel_id");
            int locatario = resultado.getInt("locatario_id");

            //contrato = new Contrato(...)
            return contrato;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Contrato> obterContratos() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Contrato contrato = null;
        List<Contrato> contratos = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM contrato;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                
                int id = resultado.getInt("id");
                Date dataInicio = resultado.getDate("dataInicio");
                Date dataFim = resultado.getDate("dataTermino");
                double valor = resultado.getDouble("valor");
                int imovel = resultado.getInt("imovel_id");
                int locatario = resultado.getInt("locatario_id");

                //contrato = new Contrato(...)
                contratos.add(contrato);
            }
            return contratos;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

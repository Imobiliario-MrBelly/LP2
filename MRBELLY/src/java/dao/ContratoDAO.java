package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Contrato;
import models.Imovel;
import models.Locatario;

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

            comando = conexao.prepareStatement("INSERT INTO contrato (imovel, locatario, dataInicio, dataFim, valor) VALUES (?,?,?,?,?);");

            comando.setInt(1, contrato.getImovel().getId());
            comando.setInt(2, contrato.getLocatario().getId());
            comando.setDate(3, new java.sql.Date(contrato.getDataInicio().getTime()));
            comando.setDate(4, new java.sql.Date(contrato.getDataFim().getTime()));
            comando.setDouble(5, contrato.getValor());
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
            comando = conexao.prepareStatement("UPDATE contrato SET imovel=?, locatario=?,"
                    + " dataInicio=?, dataFim=?, valor=? WHERE id=?;");

            comando.setInt(1, contrato.getImovel().getId());
            comando.setInt(2, contrato.getLocatario().getId());
            comando.setDate(3, new java.sql.Date(contrato.getDataInicio().getTime()));
            comando.setDate(4, new java.sql.Date(contrato.getDataFim().getTime()));
            comando.setDouble(5, contrato.getValor());
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
            return comando.execute();
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

            while (resultado.next()) {
                int imovel = resultado.getInt("imovel");
                int locatario = resultado.getInt("locatario");
                Date dataInicio = resultado.getDate("dataInicio");
                Date dataFim = resultado.getDate("dataFim");
                double valor = resultado.getDouble("valor");

                Imovel i = ImovelDAO.getInstancia().obterImovel(imovel);
                Locatario l = LocatarioDAO.getInstancia().obterLocatario(locatario);

                contrato = new Contrato(id, i, l, dataInicio, dataFim, valor);
            }
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
            comando = conexao.prepareStatement("SELECT * FROM contrato");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {

                int id = resultado.getInt("id");
                int imovel = resultado.getInt("imovel");
                int locatario = resultado.getInt("locatario");
                Date dataInicio = resultado.getDate("dataInicio");
                Date dataFim = resultado.getDate("dataFim");
                double valor = resultado.getDouble("valor");

                Imovel i = ImovelDAO.getInstancia().obterImovel(imovel);
                Locatario l = LocatarioDAO.getInstancia().obterLocatario(locatario);

                contrato = new Contrato(id, i, l, dataInicio, dataFim, valor);
                contratos.add(contrato);
            }
            return contratos;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

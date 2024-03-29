package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Endereco;

public class EnderecoDAO extends DAO {

    private static EnderecoDAO instancia = new EnderecoDAO();

    public static EnderecoDAO getInstancia() {
        return instancia;
    }

    public int gravar(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);

            comando = conexao.prepareStatement("INSERT INTO endereco (rua, numero, cep, cidade, uf) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, endereco.getRua());
            comando.setString(2, endereco.getNumero());
            comando.setString(3, endereco.getCep());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getUf());
            comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            conexao.commit();
            return id;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE endereco SET rua=?, numero=?, cep=?, cidade=?, uf=? WHERE id=?;");
            comando.setString(1, endereco.getRua());
            comando.setString(2, endereco.getNumero());
            comando.setString(3, endereco.getCep());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getUf());
            comando.setInt(6, endereco.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("Delete From endereco Where id= ?");
            comando.setInt(1, endereco.getId());
            comando.execute();
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Endereco obterEndereco(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM endereco WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String rua = resultado.getNString("rua");
                String numero = resultado.getNString("numero");
                String cep = resultado.getNString("cep");
                String cidade = resultado.getNString("cidade");
                String uf = resultado.getNString("uf");

                endereco = new Endereco(id, rua, numero, cep, cidade, uf);
            }
            return endereco;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Endereco> obterEnderecos() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Endereco endereco = null;
        List<Endereco> enderecos = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM endereco");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String rua = resultado.getNString("rua");
                String numero = resultado.getNString("numero");
                String cep = resultado.getNString("cep");
                String cidade = resultado.getNString("cidade");
                String uf = resultado.getNString("uf");

                endereco = new Endereco(id, rua, numero, cep, cidade, uf);
                enderecos.add(endereco);
            }
            return enderecos;
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

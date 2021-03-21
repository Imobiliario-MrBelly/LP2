package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

public class PessoaDAO extends DAO {

    static private PessoaDAO instancia = new PessoaDAO();

    public static PessoaDAO getInstancia() {
        return instancia;
    }

    public int gravar(Pessoa p) throws SQLException, ClassNotFoundException,
            CloneNotSupportedException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);

            comando = conexao.prepareStatement("INSERT INTO pessoa (nome, cpf, rg, sobrenome,"
                    + " sexo, cadastro, telefone) VALUES (?,?,?,?,?,curdate(),?);", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, p.getNome());
            comando.setString(2, p.getCpf());
            comando.setString(3, p.getRg());
            comando.setString(4, p.getSobrenome());
            comando.setString(5, p.getSexo());
            comando.setString(6, p.getTelefone());

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

    public boolean alterar(Pessoa p) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("UPDATE pessoa SET nome=?, sobrenome=?,  rg=?, cpf=?, sexo=?, telefone=? WHERE id=?;");

            comando.setString(1, p.getNome());
            comando.setString(2, p.getSobrenome());
            comando.setString(3, p.getRg());
            comando.setString(4, p.getCpf());
            comando.setString(5, p.getSexo());

            comando.setString(6, p.getTelefone());
            comando.setInt(7, p.getId());

            return comando.executeUpdate() > 0;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Pessoa p) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("DELETE FROM pessoa WHERE id=?;");

            comando.setInt(1, p.getId());
            return comando.executeUpdate() > 0;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Pessoa obterPessoa(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        Pessoa p = null;
        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("SELECT * FROM pessoa WHERE id=?;");

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String sobrenome = resultado.getString("sobrenome");
                String rg = resultado.getString("rg");
                String cpf = resultado.getString("cpf");
                String sexo = resultado.getString("sexo");
                Date dataCadastro = resultado.getDate("cadastro");
                String telefone = resultado.getString("telefone");

                p = new Pessoa(id, nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);

            }
            return p;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Pessoa> obterPessoas() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        Pessoa p = null;
        List<Pessoa> pessoas = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("SELECT * FROM pessoa;");

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String sobrenome = resultado.getString("sobrenome");
                String rg = resultado.getString("rg");
                String cpf = resultado.getString("cpf");
                String sexo = resultado.getString("sexo");
                Date dataCadastro = resultado.getDate("cadastro");
                String telefone = resultado.getString("telefone");

                p = new Pessoa(id, nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);
                pessoas.add(p);

            }

            return pessoas;

        } finally {
            fecharConexao(conexao, comando);
        }
    }
}

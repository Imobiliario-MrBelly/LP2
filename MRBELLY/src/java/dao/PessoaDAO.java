package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

public class PessoaDAO extends DAO {

    static private PessoaDAO instancia = new PessoaDAO();

    public static PessoaDAO getInstancia() {
        return instancia;
    }

    public void gravar(Pessoa p) throws SQLException, ClassNotFoundException,
            CloneNotSupportedException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO PESSOA(nome, sobrenome, "
                    + "rg, cpf, nascimento, sexo, dataCadastro) VALUES (?,?,?,?,?);");

            comando.setString(1, p.getNome());
            comando.setString(2, p.getSobrenome());
            comando.setString(3, p.getRg());
            comando.setString(4, p.getCpf());
            comando.setDate(8, (Date) p.getDataCadastro());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Pessoa p) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("UPDATE PESSOA SET nome=?, sobrenome=?,  rg=?, cpf=?, nascimento=?, sexo=?, dataCadastro=?, telefone=? WHERE id=?;");

            comando.setString(1, p.getNome());
            comando.setString(2, p.getSobrenome());
            comando.setString(3, p.getRg());
            comando.setString(4, p.getCpf());
            comando.setDate(8, (Date) p.getDataCadastro());
            comando.setString(9, p.getTelefone());

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

            comando = conexao.prepareStatement("DELETE FROM PESSOA WHERE id=?;");

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

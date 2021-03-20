package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Endereco;
import models.Imovel;
import models.Locador;
import models.Login;
import models.Pessoa;

public class LocadorDAO extends DAO {

    private static LocadorDAO instancia = new LocadorDAO();

    public static LocadorDAO getInstancia() {
        return instancia;
    }

    public void gravar(Locador locador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO locador (pessoa,login,endereco) VALUES (?,?,?);");
            comando.setInt(1, locador.getPessoa().getId());
            comando.setInt(2, locador.getLogin().getId());
            comando.setInt(3, locador.getEndereco().getId());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Locador locador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE locador SET login=?, endereco=?,pessoa=? WHERE id=?;");
            comando.setInt(1, locador.getLogin().getId());
            comando.setInt(2, locador.getEndereco().getId());
            comando.setInt(3, locador.getPessoa().getId());
            comando.setInt(4, locador.getId());

            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Locador locador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            PessoaDAO.getInstancia().excluir(locador.getPessoa());
            LoginDAO.getInstancia().excluir(locador.getLogin());
            EnderecoDAO.getInstancia().excluir(locador.getEndereco());
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM locador WHERE id=?;");
            comando.setInt(1, locador.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Locador obterLocador(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Locador locador = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM locador WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                locador = instanciaLocador(resultado);
            }
            return locador;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Locador> obterLocadores() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Locador locador = null;
        List<Locador> locadores = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM locador;");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                locador = instanciaLocador(resultado);
                locadores.add(locador);
            }
            return locadores;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Locador instanciaLocador(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Locador locador = null;
        int id = resultado.getInt("id");
        Endereco endereco = EnderecoDAO.getInstancia().obterEndereco(resultado.getInt("endereco"));
        Login login = LoginDAO.getInstancia().obterLogin(resultado.getInt("login"));
        Pessoa pessoa = PessoaDAO.getInstancia().obterPessoa(resultado.getInt("pessoa"));
        locador = new Locador(id, pessoa, endereco, login);
        return locador;
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Endereco;
import models.Locador;
import models.Login;
import models.Pessoa;

public class LoginDAO extends DAO {

    static private LoginDAO instancia = new LoginDAO();

    public static LoginDAO getInstancia() {
        return instancia;
    }

    public int gravar(Login login) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);

            comando = conexao.prepareStatement("INSERT INTO login (senha, email, status) VALUES (?,?,0);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, login.getSenha());
            comando.setString(2, login.getEmail());
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

    public boolean alterar(Login login) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("UPDATE login SET email=?, senha=? WHERE id=?;");
            comando.setString(1, login.getEmail());
            comando.setString(2, login.getSenha());
            comando.setInt(3, login.getId());

            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Login login) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("DELETE FROM login WHERE id=?;");
            comando.setInt(1, login.getId());
            return comando.executeUpdate() > 0;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Login obterLogin(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Login login = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM login WHERE id=?;");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                login = instanciaLogin(resultado);
            }
            return login;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Login> obterLogins() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Login login = null;
        List<Login> logins = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("SELECT * FROM login");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                login = instanciaLogin(resultado);
                logins.add(login);
            }
            return logins;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Login instanciaLogin(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Login login = null;
        int id = resultado.getInt("id");
        String email = resultado.getNString("email");
        String senha = resultado.getNString("senha");
        login = new Login(id, email, senha);
        return login;
    }
}

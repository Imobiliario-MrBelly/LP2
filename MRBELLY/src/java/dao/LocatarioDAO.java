package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Locatario;
import models.Login;
import models.Pessoa;

public class LocatarioDAO extends DAO {

    private static LocatarioDAO instancia = new LocatarioDAO();

    public static LocatarioDAO getInstancia() {
        return instancia;
    }

    public void gravar(Locatario locatario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("insert into locatario (pessoa,login) values(?,?)");
            comando.setInt(1, locatario.getPessoa().getId());
            comando.setInt(2, locatario.getLogin().getId());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(Locatario locatario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("update locatario set login=?,pessoa=? where id = ?");
            comando.setInt(2, locatario.getPessoa().getId());
            comando.setInt(1, locatario.getLogin().getId());
            comando.setInt(3, locatario.getId());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(Locatario locatario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("delete from locatario where id = ?");

            comando.setInt(1, locatario.getId());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Locatario obterLocatario(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Locatario locatario = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("select * from locatario where id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                locatario = instanciaLocatario(resultado);
            }

            return locatario;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Locatario> obterLocatarios() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        List<Locatario> locatarios = new ArrayList<>();
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement("select * from locatario");

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                locatarios.add(instanciaLocatario(resultado));
            }
            return locatarios;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Locatario instanciaLocatario(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Locatario locatario = null;
        int id = resultado.getInt("id");
        int pessoa = resultado.getInt("pessoa");
        int login = resultado.getInt("login");

        Pessoa p = PessoaDAO.getInstancia().obterPessoa(pessoa);
        Login l = LoginDAO.getInstancia().obterLogin(login);

        locatario = new Locatario(id, p, l);
        return locatario;
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement("INSERT INTO pessoa (nome, cpf, rg, sobrenome,"
                    + " sexo, cadastro, telefone) VALUES (?,?,?,?,?,curdate(),?);", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, locatario.getPessoa().getNome());
            comando.setString(2, locatario.getPessoa().getCpf());
            comando.setString(3, locatario.getPessoa().getRg());
            comando.setString(4, locatario.getPessoa().getSobrenome());
            comando.setString(5, locatario.getPessoa().getSexo());
            comando.setString(6, locatario.getPessoa().getTelefone());

            comando.executeUpdate();
            ResultSet rs = comando.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            locatario.getPessoa().setId(id);

            comando = conexao.prepareStatement("INSERT INTO login (senha, email, status) VALUES (?,?,0);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, locatario.getLogin().getSenha());
            comando.setString(2, locatario.getLogin().getEmail());
            comando.executeUpdate();

            rs = comando.getGeneratedKeys();
            id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            locatario.getLogin().setId(id);

            comando = conexao.prepareStatement("insert into locatario (pessoa,login) values(?,?)");
            comando.setInt(1, locatario.getPessoa().getId());
            comando.setInt(2, locatario.getLogin().getId());
            comando.executeUpdate();
            conexao.commit();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(Locatario locatario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement("UPDATE login SET email=?, senha=? WHERE id=?;");
            comando.setString(1, locatario.getLogin().getEmail());
            comando.setString(2, locatario.getLogin().getSenha());
            comando.setInt(3, locatario.getLogin().getId());

            comando = conexao.prepareStatement("UPDATE pessoa SET nome=?, sobrenome=?,  rg=?, cpf=?, sexo=?, telefone=? WHERE id=?;");

            comando.setString(1, locatario.getPessoa().getNome());
            comando.setString(2, locatario.getPessoa().getSobrenome());
            comando.setString(3, locatario.getPessoa().getRg());
            comando.setString(4, locatario.getPessoa().getCpf());
            comando.setString(5, locatario.getPessoa().getSexo());
            comando.setString(6, locatario.getPessoa().getTelefone());
            comando.setInt(7, locatario.getPessoa().getId());

            comando = conexao.prepareStatement("update locatario set login=?,pessoa=? where id = ?");
            comando.setInt(2, locatario.getPessoa().getId());
            comando.setInt(1, locatario.getLogin().getId());
            comando.setInt(3, locatario.getId());
            comando.executeUpdate();
            conexao.commit();
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

            while (resultado.next()) {
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

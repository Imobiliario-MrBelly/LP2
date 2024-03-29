package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        //ola mundo
        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement("INSERT INTO pessoa (nome, cpf, rg, sobrenome,"
                    + " sexo, cadastro, telefone) VALUES (?,?,?,?,?,curdate(),?);", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, locador.getPessoa().getNome());
            comando.setString(2, locador.getPessoa().getCpf());
            comando.setString(3, locador.getPessoa().getRg());
            comando.setString(4, locador.getPessoa().getSobrenome());
            comando.setString(5, locador.getPessoa().getSexo());
            comando.setString(6, locador.getPessoa().getTelefone());

            comando.executeUpdate();
            ResultSet rs = comando.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            locador.getPessoa().setId(id);
            id = 0;

            comando = conexao.prepareStatement("INSERT INTO login (senha, email, status) VALUES (?,?,0);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, locador.getLogin().getSenha());
            comando.setString(2, locador.getLogin().getEmail());
            comando.executeUpdate();

            rs = comando.getGeneratedKeys();

            while (rs.next()) {
                id = rs.getInt(1);
            }
            locador.getLogin().setId(id);

            comando = conexao.prepareStatement("INSERT INTO endereco (rua, numero, cep, cidade, uf) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, locador.getEndereco().getRua());
            comando.setString(2, locador.getEndereco().getNumero());
            comando.setString(3, locador.getEndereco().getCep());
            comando.setString(4, locador.getEndereco().getCidade());
            comando.setString(5, locador.getEndereco().getUf());
            comando.executeUpdate();

            rs = comando.getGeneratedKeys();
            id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            locador.getEndereco().setId(id);

            comando = conexao.prepareStatement("INSERT INTO locador (pessoa,login,endereco) VALUES (?,?,?);");
            comando.setInt(1, locador.getPessoa().getId());
            comando.setInt(2, locador.getLogin().getId());
            comando.setInt(3, locador.getEndereco().getId());
            comando.executeUpdate();
            conexao.commit();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Locador locador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);

            comando = conexao.prepareStatement("UPDATE endereco SET rua=?, numero=?, cep=?, cidade=?, uf=? WHERE id=?;");
            comando.setString(1, locador.getEndereco().getRua());
            comando.setString(2, locador.getEndereco().getNumero());
            comando.setString(3, locador.getEndereco().getCep());
            comando.setString(4, locador.getEndereco().getCidade());
            comando.setString(5, locador.getEndereco().getUf());
            comando.setInt(6, locador.getEndereco().getId());

            comando = conexao.prepareStatement("UPDATE login SET email=?, senha=? WHERE id=?;");
            comando.setString(1, locador.getLogin().getEmail());
            comando.setString(2, locador.getLogin().getSenha());
            comando.setInt(3, locador.getLogin().getId());

            comando = conexao.prepareStatement("UPDATE pessoa SET nome=?, sobrenome=?,  rg=?, cpf=?, sexo=?, telefone=? WHERE id=?;");

            comando.setString(1, locador.getPessoa().getNome());
            comando.setString(2, locador.getPessoa().getSobrenome());
            comando.setString(3, locador.getPessoa().getRg());
            comando.setString(4, locador.getPessoa().getCpf());
            comando.setString(5, locador.getPessoa().getSexo());
            comando.setString(6, locador.getPessoa().getTelefone());
            comando.setInt(7, locador.getPessoa().getId());

            comando = conexao.prepareStatement("UPDATE locador SET login=?, endereco=?,pessoa=? WHERE id=?;");
            comando.setInt(1, locador.getLogin().getId());
            comando.setInt(2, locador.getEndereco().getId());
            comando.setInt(3, locador.getPessoa().getId());
            comando.setInt(4, locador.getId());
            conexao.commit();
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

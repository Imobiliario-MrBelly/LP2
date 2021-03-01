package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import models.Pessoa;
import models.Telefone;

public class TelefoneDAO extends DAO {

    static private TelefoneDAO instancia = new TelefoneDAO();

    static public TelefoneDAO getInstacia() {
        return instancia;
    }

    public void gravar(Telefone telefone) throws SQLException, ClassNotFoundException, CloneNotSupportedException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("INSERT INTO TELEFONE(numero, descrição, pessoa_id)");

            comando.setString(1, telefone.getNumero());
            comando.setString(3, telefone.getDescricao());
            if (telefone.getPessoaId() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setNull(4, telefone.getPessoaId().getId());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean alterar(Telefone t) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("UPDATE PESSOA SET numero=?, descrição=? WHERE id=?;");

            comando.setString(1, t.getNumero());
            comando.setString(2, t.getDescricao());

            return comando.executeUpdate() > 0;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public boolean excluir(Telefone t) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("DELETE FROM casa WHERE id=?;");

            comando.setInt(1, t.getId());
            return comando.executeUpdate() > 0;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public Telefone obterTelefone(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        Telefone t = null;
        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("SELECT * FROM telefone WHERE id=?;");

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            boolean first = resultado.first();
            String numero = resultado.getString("numero");
            String descricao = resultado.getString("descricao");

            return t;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public List<Telefone> obterTelefones() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        Telefone t = null;
        List<Telefone> pessoas = new ArrayList();

        try {
            conexao = BD.getInstancia().getConexao();

            comando = conexao.prepareStatement("SELECT * FROM telefone;");

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String numero = resultado.getString("numero");
                String ddd = resultado.getString("ddd");
                String descricao = resultado.getString("descricao");
                String pessoaId = resultado.getString("pessoa");
                
                Pessoa p = PessoaDAO.getInstancia().obterPessoa(id);
                
                t = new Telefone(id, ddd, numero, descricao, p);
                pessoas.add(t);

            }

            return pessoas;

        } finally {
            fecharConexao(conexao, comando);
        }
    }

}

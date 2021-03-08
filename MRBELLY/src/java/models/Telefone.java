package models;

import dao.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

public class Telefone {

    private int id;
    private String ddd;
    private String numero;
    private String descricao;
    private Pessoa pessoaId;

    public Telefone(int id,String ddd, String numero, String descricao, Pessoa pessoaId) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
        this.descricao = descricao;
        this.pessoaId = pessoaId;
    }
    public Telefone(String ddd, String numero, String descricao, Pessoa pessoaId) {
        this.numero = numero;
        this.descricao = descricao;
        this.pessoaId = pessoaId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public static List<Telefone> obterTelefones() throws SQLException, ClassNotFoundException {
        return TelefoneDAO.getInstacia().obterTelefones();
    }
}

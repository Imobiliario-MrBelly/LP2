package models;

import dao.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

public class Telefone {

    private int id;
    private String numero;
    private String descricao;
    private Pessoa pessoaId;

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Telefone(String ddd, String numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
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
public static List<Telefone> obterTelefones() throws SQLException, ClassNotFoundException{
    return TelefoneDAO.getInstacia().obterPessoa();
}}

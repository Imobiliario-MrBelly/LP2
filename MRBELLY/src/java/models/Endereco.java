package models;

import dao.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

public class Endereco {

    private int id;
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco(String rua, String numero, String cep, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;

    }

    public Endereco(int id, String rua, String numero, String cep, String cidade, String uf) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException {
        return EnderecoDAO.getInstancia().obterEnderecos();
    }

    public static Endereco obterEndereco(int id) throws ClassNotFoundException, SQLException {
        return EnderecoDAO.getInstancia().obterEndereco(id);
    }

    public int gravar() throws SQLException, ClassNotFoundException {
        return EnderecoDAO.getInstancia().gravar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        EnderecoDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        EnderecoDAO.getInstancia().excluir(this);
    }
}

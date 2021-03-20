package models;

import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Pessoa {

    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String sexo;
    private Date dataCadastro;
    private String telefone;

    public Pessoa(int id, String nome, String sobrenome, String rg, String cpf, String sexo, Date dataCadastro, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataCadastro = dataCadastro;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static List<Pessoa> obterPessoas() throws SQLException, ClassNotFoundException {
        return PessoaDAO.getInstancia().obterPessoas();
    }
    public static Pessoa obterPessoa(int id) throws SQLException, ClassNotFoundException {
        return PessoaDAO.getInstancia().obterPessoa(id);
    }

}

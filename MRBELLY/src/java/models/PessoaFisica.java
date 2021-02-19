package models;

import java.util.Date;

public class PessoaFisica extends Pessoa {

    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private Date nascimento;
    private boolean sexo;

    public PessoaFisica(String nome, String sobrenome, String rg, String cpf, Date nascimento, boolean sexo, int codigo, Telefone telefone, Date dataCadastro) {
        super(codigo, telefone, dataCadastro);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.sexo = sexo;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }   
}

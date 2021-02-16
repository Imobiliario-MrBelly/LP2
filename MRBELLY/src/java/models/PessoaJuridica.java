package models;

import java.util.Date;

public class PessoaJuridica extends Pessoa{
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private PessoaFisica representante;

    public PessoaJuridica(String nome, String cnpj, String razaoSocial, PessoaFisica representante, int codigo, Telefone telefone, Date dataCadastro) {
        super(codigo, telefone, dataCadastro);
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.representante = representante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public PessoaFisica getRepresentante() {
        return representante;
    }

    public void setRepresentante(PessoaFisica representante) {
        this.representante = representante;
    }   
}

package models;

import java.util.Date;

public abstract class Pessoa {

    private int codigo;
    private Telefone telefone;
    private Date dataCadastro;
    
    public Pessoa(int codigo, Telefone telefone, Date dataCadastro) {
        this.codigo = codigo;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}

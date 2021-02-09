
package models;

public class Locador {
    private Pessoa pessoa;
    private Endereco endereco;
    private Login login;

    public Locador(Pessoa pessoa, Endereco endereco, Login login) {
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

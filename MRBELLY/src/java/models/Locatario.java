package models;

public class Locatario {
    private Pessoa pessoa;
    private Login login;

    public Locatario(Pessoa pessoa, Login login) {
        this.pessoa = pessoa;
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
}

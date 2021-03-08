
package models;

import dao.LocadorDAO;
import java.sql.SQLException;
import java.util.List;

public class Locador {
    private int id;
    private Pessoa pessoa;
    private Endereco endereco;
    private Login login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locador(Pessoa pessoa, Endereco endereco, Login login) {
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public Locador(int id, Pessoa pessoa, Endereco endereco, Login login) {
        this.id = id;
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.login = login;
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
public static List<Locador> obterLocadores() throws SQLException, ClassNotFoundException{
    return LocadorDAO.getInstancia().obterLocadores();
}
}

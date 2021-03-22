package models;

import dao.LocatarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Locatario {

    private int id;
    private Pessoa pessoa;
    private Login login;

    public Locatario(int id, Pessoa pessoa, Login login) {
        this.id = id;
        this.pessoa = pessoa;
        this.login = login;
    }

    public Locatario(Pessoa pessoa, Login login) {
        this.pessoa = pessoa;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static List<Locatario> obterLocatario() throws SQLException, ClassNotFoundException {
        return LocatarioDAO.getInstancia().obterLocatarios();
    }

    public static Locatario obterLocatario(int id) throws SQLException, ClassNotFoundException {
        return LocatarioDAO.getInstancia().obterLocatario(id);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        LocatarioDAO.getInstancia().gravar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        LocatarioDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        LocatarioDAO.getInstancia().excluir(this);
    }
}

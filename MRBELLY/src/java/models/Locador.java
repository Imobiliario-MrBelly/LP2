
package models;

import dao.LocadorDAO;
import java.sql.SQLException;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;

public class Locador {
    private int id;
    private Endereco endereco;
    private Login login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locador(Endereco endereco, Login login) {
        this.endereco = endereco;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public Locador(int id, Endereco endereco, Login login) {
        this.id = id;
        this.endereco = endereco;
        this.login = login;
    }

    public void setLogin(Login login) {
        this.login = login;
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
    public static Locador obterLocador(int id) throws SQLException, ClassNotFoundException{
    return LocadorDAO.getInstancia().obterLocador(id);
}
}

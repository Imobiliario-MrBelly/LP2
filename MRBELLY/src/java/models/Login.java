
package models;

import dao.LoginDAO;
import java.sql.SQLException;
import java.util.List;

public class Login {
    private int id;
    private String email;
    private String senha;
    

    public Login(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
       
    }

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        
    }

   

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
public static List<Login> obterLogin() throws SQLException, ClassNotFoundException{
    return LoginDAO.getInstancia().obterLogins();
}
public static Login obterLogin(int id) throws SQLException, ClassNotFoundException{
    return LoginDAO.getInstancia().obterLogin(id);
}
}

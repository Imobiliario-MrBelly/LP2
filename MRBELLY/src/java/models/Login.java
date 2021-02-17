
package models;

public class Login {
    private int id;
    private String email;
    private String senha;
    private boolean status;

    public Login(int id, String email, String senha, boolean status) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.status = status;
    }

    public Login(String email, String senha, boolean status) {
        this.email = email;
        this.senha = senha;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
}

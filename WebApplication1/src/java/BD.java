

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    private static BD instancia = new BD();
    public static BD getInstancia(){
        return instancia;
    }

    private BD(){}

    public Connection getConexao() throws ClassNotFoundException, SQLException{

        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/mrbelly", "root", "");
       return conexao;


    }

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    private static BD instancia = new BD();

    public static BD getInstancia() {
        return instancia;
    }

    public Connection getConexao() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://db4free.net/", "todosunidos", "kxxa94eHVZ");
        return conexao;

    }

    public static void main(String Args[]) throws SQLException, ClassNotFoundException {
        BD newBd = new BD();
        newBd.getConexao();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BD {

    private static BD instancia = new BD();

    public BD getInstancia() {
        return instancia;
    }

    public Connection getConexao() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://sql5.freesqldatabase.com:3306", "sql5391594", "TtMDfIzTer");
        return conexao;
        
    }
    public static void main(String [] args) throws SQLException, ClassNotFoundException{ 
    
   BD a=new BD();
   a.getConexao();
    }
}

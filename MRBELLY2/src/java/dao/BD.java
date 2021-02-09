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

    public void getConexao() throws SQLException {

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql:sql5.freesqldatabase.com", "sql5391594", "TtMDfIzTer")) {
            System.out.println("Conectado!");
        }
    }
    public static void main(String [] args) throws SQLException{ 
    
   BD a=new BD();
   a.getConexao();
    }
}

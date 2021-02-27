/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.SQLException;


/**
 *
 * @author Rennan
 */
public class NewClass {
   public static void main(String[] args) throws SQLException, ClassNotFoundException{
       Login log1=new Login("rennandamiao@gmail.com", "1234", true);
       LoginDAO.getInstancia().gravar(log1);
       
   }
}

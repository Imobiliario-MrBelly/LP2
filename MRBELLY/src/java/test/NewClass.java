/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.LoginDAO;
import dao.TelefoneDAO;
import java.sql.SQLException;
import models.Login;
import models.Pessoa;
import models.Telefone;

/**
 *
 * @author Rennan
 */
public class NewClass {
   public static void main(String[] args) throws SQLException, ClassNotFoundException{
//       Login log1=new Login("rennandamiao@gmail.com", "1234", true);
//       LoginDAO.getInstancia().gravar(log1);
//       
       /*for(Pessoa ref : Pessoa.obterPessoas()){
           System.out.println(ref.getNome());
           System.out.println(ref.getDataCadastro());
       }*/
       
       for(Telefone t: Telefone.obterTelefones()){
           if(t.getPessoaId() != null){
               System.out.println(t.getPessoaId().getNome());
           }
       }
   }
}

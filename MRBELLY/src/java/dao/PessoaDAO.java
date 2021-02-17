package dao;

import models.Pessoa;

public class PessoaDAO {
    static private PessoaDAO instancia = new PessoaDAO();
    static PessoaDAO getInstancia(){
        return instancia;
    }
    public Pessoa obterPessoa(int id){
        return null;
    }

}

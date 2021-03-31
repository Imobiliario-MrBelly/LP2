/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Endereco;
import models.Locador;
import models.Login;
import models.Pessoa;

/**
 *
 * @author vinic
 */
public class ManterLocador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, CloneNotSupportedException, Exception {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {

            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {

            prepararOperacao(request, response);
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, ParseException, CloneNotSupportedException, Exception {
        String operacao = request.getParameter("operacao");

        String nome = new String(request.getParameter("txtNome").getBytes("ISO-8859-1"), "UTF-8");
        String sobrenome = new String(request.getParameter("txtSobrenome").getBytes("ISO-8859-1"), "UTF-8");
        String rg = request.getParameter("txtRg");
        String cpf = request.getParameter("txtCpf");
        String sexo = request.getParameter("txtSexo");
        String telefone = request.getParameter("txtTelefone");

        String cep = request.getParameter("txtCep");
        String rua = new String(request.getParameter("txtRua").getBytes("ISO-8859-1"), "UTF-8");
        String numero = request.getParameter("txtNumero");
        String cidade = new String(request.getParameter("txtCidade").getBytes("ISO-8859-1"), "UTF-8");
        String uf = request.getParameter("txtUF");
        Date dataCadastro = new Date();

        String email = request.getParameter("txtEmail");
        String senha = new String(request.getParameter("txtSenha").getBytes("ISO-8859-1"), "UTF-8");

        Pessoa pessoa = null;
        Endereco endereco = null;
        Login login = null;
        Locador locador = null;

        try {

            if (operacao.equals("Incluir")) {
                pessoa = new Pessoa(nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);
                endereco = new Endereco(rua, numero, cep, cidade, uf);
                login = new Login(email, senha);
                locador = new Locador(pessoa, endereco, login);
                locador.gravar();

            } else {
                int codLocador = Integer.parseInt(request.getParameter("txtCodLocador"));
                int idPessoa = Integer.parseInt(request.getParameter("txtCodPessoa"));
                int idEndereco = Integer.parseInt(request.getParameter("txtCodEndereco"));
                int idLogin = Integer.parseInt(request.getParameter("txtCodLogin"));
                pessoa = new Pessoa(idPessoa, nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);
                endereco = new Endereco(idEndereco, rua, numero, cep, cidade, uf);
                login = new Login(idLogin, email, senha);
                locador = new Locador(codLocador, pessoa, endereco, login);
                if (operacao.equals("Editar")) {
                    try {
                        Pessoa pessoaAntiga = Pessoa.obterPessoa(pessoa.getId());
                        pessoa.editar();
                        try {
                            Endereco enderecoAntigo = Endereco.obterEndereco(endereco.getId());
                            endereco.editar();
                            try {
                                login.editar();
                            } catch (Exception e) {
                                enderecoAntigo.editar();
                                throw new Exception(e);
                            }
                        } catch (Exception e) {
                            pessoaAntiga.editar();
                            throw new Exception(e);
                        }
                    } catch (Exception e) {

                    }
                } else {
                    if (operacao.equals("Excluir")) {
                        pessoa.excluir();
                        endereco.excluir();
                        login.excluir();
                        locador.excluir();
                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("pesquisaLocador");
            view.forward(request, response);

        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");

            request.setAttribute("operacao", operacao);
            request.setAttribute("locadores", Locador.obterLocadores());

            if (!operacao.equals("Incluir")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Locador locador = Locador.obterLocador(id);
                request.setAttribute("locador", locador);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterLocador.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;

        } catch (IOException e) {
            throw new ServletException(e);

        } catch (SQLException e) {
            throw new ServletException(e);

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ManterLocador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

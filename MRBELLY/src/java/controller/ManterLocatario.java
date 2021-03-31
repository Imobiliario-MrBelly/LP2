/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Locatario;
import models.Login;
import models.Pessoa;

/**
 *
 * @author vinic
 */
public class ManterLocatario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {

            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {

            prepararOperacao(request, response);
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, UnsupportedEncodingException {
        String operacao = request.getParameter("operacao");

        String nome = new String(request.getParameter("txtNome").getBytes("ISO-8859-1"), "UTF-8");
        String sobrenome = new String(request.getParameter("txtSobrenome").getBytes("ISO-8859-1"), "UTF-8");
        String rg = request.getParameter("txtRg");
        String cpf = request.getParameter("txtCpf");
        String sexo = request.getParameter("txtSexo");
        String telefone = request.getParameter("txtTelefone");
        Date dataCadastro = new Date();

        String email = request.getParameter("txtEmail");
        String senha = new String(request.getParameter("txtSenha").getBytes("ISO-8859-1"), "UTF-8");

        Pessoa pessoa = null;
        Login login = null;
        Locatario locatario = null;

        try {

            if (operacao.equals("Incluir")) {
                pessoa = new Pessoa(nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);
                login = new Login(email, senha);
                locatario = new Locatario(pessoa, login);
                locatario.gravar();

            } else {
                int codLocatario = Integer.parseInt(request.getParameter("txtCodLocatario"));
                int idPessoa = Integer.parseInt(request.getParameter("txtCodPessoa"));
                int idLogin = Integer.parseInt(request.getParameter("txtCodLogin"));
                pessoa = new Pessoa(idPessoa, nome, sobrenome, rg, cpf, sexo, dataCadastro, telefone);
                login = new Login(idLogin, email, senha);
                locatario = new Locatario(codLocatario, pessoa, login);

                if (operacao.equals("Editar")) {
                    try {
                        Pessoa pessoaAntiga = Pessoa.obterPessoa(pessoa.getId());
                        pessoa.editar();

                        try {
                            login.editar();

                        } catch (Exception e) {
                            pessoaAntiga.editar();
                            throw new Exception(e);
                        }
                    } catch (Exception e) {

                    }
                } else {
                    if (operacao.equals("Excluir")) {
                        pessoa.excluir();
                        login.excluir();
                        locatario.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("pesquisaLocatario");
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
            request.setAttribute("locatarios", Locatario.obterLocatario());

            if (!operacao.equals("Incluir")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Locatario locatario = Locatario.obterLocatario(id);
                request.setAttribute("locatario", locatario);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterLocatario.jsp");
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
            Logger.getLogger(ManterLocatario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLocatario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterLocatario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLocatario.class.getName()).log(Level.SEVERE, null, ex);
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

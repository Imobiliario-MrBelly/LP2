/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Endereco;

/**
 *
 * @author vinic
 */
public class ManterEndereco extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {

            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {

            prepararOperacao(request, response);
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) {
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");

            request.setAttribute("operacao", operacao);
            request.setAttribute("enderecos", Endereco.obterEnderecos());

            if (!operacao.equals("Incluir")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Endereco login = Endereco.obterEndereco(id);
                request.setAttribute("endereco", login);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterLogin.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

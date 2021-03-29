/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Endereco;
import models.Imovel;
import models.Locador;

/**
 *
 * @author vinic
 */
public class ManterImovel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {

            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {

            prepararOperacao(request, response);
        }
    }
 
     private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException {
        String operacao = request.getParameter("operacao");
        
        String cep = request.getParameter("txtCep");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUF");
        
        
        
       Endereco endereco = null;
       double area = Double.parseDouble(request.getParameter("txtArea"));
       String descricao = request.getParameter("txtDescricao");
       double condomino = Double.parseDouble(request.getParameter("txtCondominio"));
       double iptu = Double.parseDouble(request.getParameter("txtIptu"));
       int garagem = Integer.parseInt(request.getParameter("txtGaragem"));
       Locador locador = Locador.obterLocador(Integer.parseInt(request.getParameter("txtLocador")));
       Imovel imovel = null ;
        try{
            if (operacao.equals("Incluir")){
                endereco=new Endereco(rua, numero, cep, cidade, uf);
                imovel=new Imovel(endereco, area, descricao, condomino, iptu, garagem, locador);
                imovel.gravar();
            }else{
                int codImovel = Integer.parseUnsignedInt(request.getParameter("txtCodImovel"));
               endereco = Endereco.obterEndereco(Integer.parseUnsignedInt(request.getParameter("txtCodEndereco")));
                imovel= new Imovel(codImovel, endereco, area, descricao, condomino, iptu, garagem, locador);
                if (operacao.equals("Editar")){
                    imovel.editar();
                }else{
                    if(operacao.equals("Excluir")){
                    imovel.excluir();
                }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("pesquisaImovel");
            view.forward(request, response);
        }catch(IOException e ){
            throw new ServletException(e);
        }catch(ServletException e ){
            throw  e;
        }
    }


    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");

            request.setAttribute("operacao", operacao);
            request.setAttribute("imoveis", Imovel.obterImoveis());
            request.setAttribute("locadores", Locador.obterLocadores());
            if (!operacao.equals("Incluir")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Imovel imovel = Imovel.obterImovel(id);
                request.setAttribute("imovel", imovel);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterImovel.jsp");
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
            Logger.getLogger(ManterImovel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterImovel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterImovel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterImovel.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelDAO;
import java.io.IOException;
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
import models.Contrato;
import models.Imovel;
import models.Locatario;

public class ManterContrato extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        String acao = request.getParameter("acao");
        
        if (acao.equals("confirmarOperacao")) {
            
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            
            prepararOperacao(request, response);
        }
    }
    
    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, ParseException {
        String operacao = request.getParameter("operacao");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Imovel imovel = Imovel.obterImovel(Integer.parseInt(request.getParameter("txtImovel")));
        Locatario locatario = Locatario.obterLocatario(Integer.parseInt(request.getParameter("txtLocatario")));
        Date dataInicio = formato.parse(request.getParameter("txtInicio"));
        Date dataTermino = formato.parse(request.getParameter("txtFim"));
        double valor = Double.parseDouble(request.getParameter("txtValor"));
        Contrato contrato;
        
        try{
            if (operacao.equals("Incluir")){
                 contrato = new Contrato(imovel, locatario, dataInicio, dataTermino, valor);
                contrato.gravar();
            }else{
                int codContrato = Integer.parseInt(request.getParameter("txtCodContrato"));
                contrato = new Contrato(codContrato, imovel, locatario, dataInicio, dataInicio, valor);
                if (operacao.equals("Editar")){
                    contrato.editar();
                }else{
                    if(operacao.equals("Excluir")){
                    contrato.excluir();
                }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("pesquisaContrato");
            view.forward(request, response);
        }catch(IOException e ){
            throw new ServletException(e);
        }catch(SQLException e){
            throw new ServletException(e);
        }catch(ClassNotFoundException e ){
            throw  new ServletException(e);
        }catch(ServletException e ){
            throw  e;
        }
    }

    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            
            request.setAttribute("operacao", operacao);
            request.setAttribute("contratos", Contrato.obterContratos());
            request.setAttribute("locatarios", Locatario.obterLocatario());
            request.setAttribute("imoveis", Imovel.obterImoveis());
            
            if (!operacao.equals("Incluir")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Contrato contrato = Contrato.obterContrato(id);
                request.setAttribute("contrato", contrato);
            }
            
            RequestDispatcher view = request.getRequestDispatcher("/manterContrato.jsp");
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
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterContrato.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifba.contralador.subcontrolador.LogicaOperacao;

/**
 *
 * @author diocesse
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String logicaOperacao = req.getParameter("operacao");
        String classe = "edu.ifba.contralador.subcontrolador." + logicaOperacao;
        try {
            if (classe != null) {
                Class classOperacao = Class.forName(classe);
                LogicaOperacao operacao = (LogicaOperacao) classOperacao.newInstance();
                operacao.execute(req, resp);
            }
        } catch (ClassNotFoundException e) {
           resp.getOutputStream().println("Falha: "+e.getLocalizedMessage());
        } catch (InstantiationException e) {
            System.err.println("" + e.getMessage());
            resp.getOutputStream().println("Falha: "+e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            System.err.println("" + e.getMessage());
            resp.getOutputStream().println("Falha: "+e.getLocalizedMessage());

        } catch (ServletException e) {
            System.err.println("" + e.getMessage());
            resp.getOutputStream().println("Falha: "+e.getLocalizedMessage());
        } catch (IOException e) {
            System.err.println("" + e.getMessage());
            resp.getOutputStream().println("Falha: "+e.getLocalizedMessage());
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

        service(request, response);
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

        service(request, response);
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

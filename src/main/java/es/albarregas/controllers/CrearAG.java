/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.IEquiposDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "CrearAG", urlPatterns = {"/CrearAG"})
public class CrearAG extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
            
        String url=null;
        if(request.getParameter("seleccion").equals("alumnos")){
            url="/JSPX/Menus/MenuCrearA.jspx"; 
            
            DAOFactory daof = DAOFactory.getDAOFactory((int)1);//Creamos la conexion
            ArrayList grupos;//creamos el array de grupos
            IEquiposDAO edao = daof.getEquiposDAO();//obtenemos los grupos de la BD
            String clausulaWhere = new String(); //Creamos la clausula que le vamos a pasar al metodo
            grupos = edao.getEquipos(clausulaWhere);//le pasamos la clausula
            request.setAttribute("grupos", (Object)grupos);//creamos el atributo
            
            HttpSession session = request.getSession(true);//creamos una sesion para poder utilizarla en otras clases
            session.setAttribute("grupos", (Object)grupos);
            
        }else{
            url="/JSPX/Menus/MenuCrearG.jspx";           
        }
        request.getRequestDispatcher(url).forward(request, response);
            
            
         
        
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

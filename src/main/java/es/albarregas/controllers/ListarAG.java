/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ListarAG", urlPatterns = {"/ListarAG"})
public class ListarAG extends HttpServlet {

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
  //Si hemos elegido equipos iremos al menu de listado de equipos
        if(request.getParameter("seleccion").equals("Equipos")){
            url="/JSPX/Menus/MenuListarG.jspx";     
        }else if(request.getParameter("seleccion").equals("alumnos")){//Si hemos seleccionado alumnos iremos al menu listar de alumnos
            url="/JSPX/Menus/MenuListarA.jspx";     
        }else if(request.getParameter("seleccion").equals("Ambos")){//Si hemos seleccionado ambos iremos al menu listar la relacion de entre ambos
            ArrayList ambos;//Creamos el array de ambos
            DAOFactory daof = DAOFactory.getDAOFactory((int)1);//creamos la conexion de tipo MySql
            IAlumnosDAO adao = daof.getAlumnosDAO();//obtenemos los alumnos de la base de datos
            adao.closeConnection();//finalizamos la conexion
            ambos = adao.getAlumnosEquipo();//pasamos los datos al array
            request.setAttribute("ambos", ambos);//y as guardamos en un atributo
            
            
            url="/JSPX/Listar/ListadoAG.jspx";  
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

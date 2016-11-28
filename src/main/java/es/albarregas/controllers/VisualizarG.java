/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.IAlumnosDAO;
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

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "VisualizarG", urlPatterns = {"/VisualizarG"})
public class VisualizarG extends HttpServlet {

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
         
            DAOFactory daof = DAOFactory.getDAOFactory((int)1);
           
            IEquiposDAO edao = daof.getEquiposDAO();
            String url;
            
           
                 url="/JSPX/Listar/Grupos.jspx";
            
         
               ArrayList grupos;
               
            if(request.getParameter("todos")==null){//si no hemos selecionado todos te muestra los que quieras
                if(!request.getParameter("cuantos").equals("0")){//si hemos seleccionado o pues nos mostrara todos
     
                    String clausulaWhere  = "limit "+request.getParameter("cuantos");  

                    grupos = edao.getEquipos(clausulaWhere);
                    edao.closeConnection();
                    request.setAttribute("grupos", (Object)grupos);

                }else{//y aqui nos mostrara los que queramos ver y no todos
                    String clausulaWhere = new String(); 
                    
                   
                    grupos = edao.getEquipos(clausulaWhere);
                    edao.closeConnection();
                    request.setAttribute("grupos", (Object)grupos);
                }
            
            }else{//hemos seleccionado todos por lo que nos mostrara todos
                    String clausulaWhere = new String(); 
                    grupos = edao.getEquipos(clausulaWhere);
                    edao.closeConnection();
                    request.setAttribute("grupos", (Object)grupos);
                
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

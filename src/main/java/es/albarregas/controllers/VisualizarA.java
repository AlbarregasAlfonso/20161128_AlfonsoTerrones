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
@WebServlet(name = "VisualizarA", urlPatterns = {"/VisualizarA"})
public class VisualizarA extends HttpServlet {

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
            IAlumnosDAO adao = daof.getAlumnosDAO();
            String url="/JSPX/Listar/Alumnos.jspx";
            ArrayList alumnos;
            
               
            if(request.getParameter("todos")==null){//si no hemos selecionado todos es que queremos ver unos cuantos
                if(!request.getParameter("cuantos").equals("0")){//0 te los muestra todos
     
                    String clausulaWhere  = "limit "+request.getParameter("cuantos");  
                    alumnos = adao.getAlumnos(clausulaWhere);
                    adao.closeConnection();
                    request.setAttribute("alumnos", (Object)alumnos);
                }else{//y sino te muestra ls que le hayas pasado
                    String clausulaWhere = new String(); 
                    alumnos = adao.getAlumnos(clausulaWhere);
                    adao.closeConnection();
                    request.setAttribute("alumnos", (Object)alumnos);
                }
            
            }else{//si hemos seleccionado pues te los muestra todos
                    String clausulaWhere = new String();  
                    alumnos = adao.getAlumnos(clausulaWhere);
                    adao.closeConnection();
                    request.setAttribute("alumnos", (Object)alumnos);
        
                
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

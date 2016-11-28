/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
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
@WebServlet(name = "CrearA", urlPatterns = {"/CrearA"})
public class CrearA extends HttpServlet {

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
       
            
            ArrayList<Equipo> grupos;//Nos creamos el array de equipos
            
            grupos=(ArrayList) request.getSession().getAttribute("grupos");//pasamos el valodr de la sesion a el array grupos
    
            int opcionInt = Integer.parseInt(request.getParameter("opcion"));//Pasamos el String a int para poder crear el objeto
            for(Equipo g:grupos){
                
                if(g.getIdEquipo()==opcionInt){
    
                    Equipo eq=new Equipo(g.getIdEquipo(),g.getMarca(),g.getNumSerie());//creamos el objeto que vamos a pasar al metodo
                    Alumno al=new Alumno(request.getParameter("nombre"),request.getParameter("grupo"),eq);//creamos el otro objeto
                    DAOFactory daof = DAOFactory.getDAOFactory((int)1);//creamos la conexion
                    IAlumnosDAO adao = daof.getAlumnosDAO();//obteniemos los datos de alumnos de la BD
                    adao.addAlumno(al);//añadimos el bjeto a la base de datos
                    adao.closeConnection();//finalizamos la conexion
                
                request.getRequestDispatcher("index.jspx").forward(request, response);
                }
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

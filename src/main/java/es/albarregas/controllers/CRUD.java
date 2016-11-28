/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.IAlumnosDAO
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.daofactory.DAOFactory
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package es.albarregas.controllers;


import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="CRUD", urlPatterns={"/crud"})
public class CRUD
extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String url="";
 
        DAOFactory daof = DAOFactory.getDAOFactory((int)1);
        IAlumnosDAO adao = daof.getAlumnosDAO();
        IEquiposDAO edao = daof.getEquiposDAO();
       
         String clausulaWhere = new String();
 
        ArrayList alumnos;
        
        alumnos = adao.getAlumnos(clausulaWhere);
        
        
 
 
 //En este menu vamos a elegir la opcion que nos haya pedido el usuario en el menu principal
        switch(request.getParameter("opcion")){
            case "ver":
                url="/JSPX/Listar.jspx";
                break;   
            case "eliminar":
                request.setAttribute("alumnos", (Object)alumnos);
                url="/JSPX/Eliminar.jspx";
                break;  
             case "crear":
                url="/JSPX/Crear.jspx";
                break; 
             case "editar":
                url="/JSPX/Editar.jspx";
                break; 
        }
        
        request.getRequestDispatcher(url).forward(request, response);
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}

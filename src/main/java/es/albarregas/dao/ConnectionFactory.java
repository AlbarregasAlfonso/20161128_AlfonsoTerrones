
 /*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package es.albarregas.dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import org.apache.log4j.Logger;

public class ConnectionFactory {
    static DataSource ds = null;
    static Connection conexion = null;
    static final String DATASOURCE_NAME = "java:comp/env/jdbc/pool";
   // static final Logger LOGGER = Logger.getRootLogger();
    
    
    public static Connection getConnection() {
        try {
            InitialContext contextoInicial = new InitialContext();
            ds = (DataSource)contextoInicial.lookup("java:comp/env/jdbc/pool");
            conexion = ds.getConnection();
        }
        catch (SQLException | NamingException ex) {
         //   LOGGER.fatal((Object)"Problemas en el acceso al pool de conexiones", (Throwable)ex);
        }
        return conexion;
    }

    public static void closeConnection() {//aqui cerrariamos la sesion
        try {
            conexion.close();
        }
        catch (SQLException e) {
            System.out.println("Error al cerrar la conexi\u00f3n a la BD");
            e.printStackTrace();
        }
    }
}
/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.beans.Alumno
 *  es.albarregas.beans.Equipo
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import es.albarregas.dao.ConnectionFactory;
import es.albarregas.dao.IAlumnosDAO;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlAlumnosDAO
implements IAlumnosDAO {
    @Override
    public void addAlumno(Alumno alumno) {
        try {
            String sql = "insert into alumnos (nombre,grupo,idEquipo) values (?,?,?)";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, alumno.getNombre());
            preparada.setString(2, alumno.getGrupo());
            preparada.setInt(3, alumno.getEquipo().getIdEquipo());
            preparada.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Alumno> getAlumnos(String where) {
        ArrayList<Alumno> lista;
        if (where == null) {
            where = "";
        }
        lista = new ArrayList<Alumno>();
        String consulta = "SELECT * FROM alumnos " + where;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(resultado.getInt("idAlumno"));
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setGrupo(resultado.getString("grupo"));
                    lista.add(alumno);
                }
            }
            catch (Throwable alumno) {
                throwable = alumno;
                throw alumno;
            }
            finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        }
                        catch (Throwable alumno) {
                            throwable.addSuppressed(alumno);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipo() {
        ArrayList<Alumno> lista;
        lista = new ArrayList<Alumno>();
        String consulta = "SELECT a.nombre,e.marca,e.numSerie FROM alumnos as a left join equipos as e using(idEquipo)";//sentencia para poder ver la reacion entre alumnos y equipos
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setNombre(resultado.getString(1));
                    Equipo equipo = new Equipo();
                    equipo.setMarca(resultado.getString(2));
                    equipo.setNumSerie(resultado.getString(3));
                    alumno.setEquipo(equipo);
                    lista.add(alumno);
                }
            }
            catch (Throwable alumno) {
                throwable = alumno;
                throw alumno;
            }
            finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        }
                        catch (Throwable alumno) {
                            throwable.addSuppressed(alumno);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        try {
            String sql = "update alumnos set nombre=?,grupo=? where idAlumno=?";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, alumno.getNombre());
            preparada.setString(2, alumno.getGrupo());
            preparada.setInt(3, alumno.getIdAlumno());
            preparada.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAlumnos2(String Where){
        String sql="delete from alumnos where nombre='"+Where+"'";
        System.out.println("Vamos a borrarrrrrrrrrrrrrrr"+sql);
        try{
           // String sql="delete from alumnos where nombre='"+Where+"'";
             Statement sentencia = ConnectionFactory.getConnection().createStatement();
            sentencia.executeUpdate(sql);
            //System.out.println("Vamos a borrarrrrrrrrrrrrrrr"+sql);
            
             }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    @Override
    public void deleteAlumnos(String clausulaWhere) {
        
        try {
            String sql = "delete from alumnos " + clausulaWhere;//pasariamos la sentencia where
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            //System.out.println("Vamos a borrarrrrrrrrrrrrrrr "+sql);
            sentencia.executeUpdate(sql);//pasamos la sentencia creada
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al elimnar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
}
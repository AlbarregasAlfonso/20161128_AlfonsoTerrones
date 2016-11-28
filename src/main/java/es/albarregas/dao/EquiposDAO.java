/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.beans.Equipo
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.dao.MysqlAlumnosDAO
 */
package es.albarregas.dao;

import es.albarregas.beans.Equipo;
import es.albarregas.dao.ConnectionFactory;
import es.albarregas.dao.IEquiposDAO;
import es.albarregas.dao.MysqlAlumnosDAO;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquiposDAO implements IEquiposDAO {
    public void addEquipo(Equipo equipo) {
         try {
            String sql = "insert into equipos (marca,numSerie) values (?,?)";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, equipo.getMarca());
            preparada.setString(2, equipo.getNumSerie());
            preparada.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Equipo> getEquipos(String clausulaWhere) {
        ArrayList<Equipo> lista;
        lista = new ArrayList<Equipo>();
        String consulta = "SELECT * FROM equipos " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setIdEquipo(resultado.getInt("idEquipo"));
                    equipo.setMarca(resultado.getString("marca"));
                    equipo.setNumSerie(resultado.getString("numSerie"));
                    lista.add(equipo);
                }
            }
            catch (Throwable equipo) {
                throwable = equipo;
                throw equipo;
            }
            finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        }
                        catch (Throwable equipo) {
                            throwable.addSuppressed(equipo);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia de consulta");
            ex.printStackTrace();
        }
        return lista;
    }

    public void deleteEquipos(String clausulaWhere) {
        try {
            String sql = "delete from equipos " + clausulaWhere;
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            sentencia.executeUpdate(sql);
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al elimnar equipos");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEquipo(Equipo equipo) {
         try {
            String sql = "update equipos set marca=?,numSerie=? where idEquipo=?";//le pasamos los valores en los interrogantes
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, equipo.getMarca());//aqui se los pasamos
            preparada.setString(2, equipo.getNumSerie());//aqui se los pasamos
            preparada.setInt(3, equipo.getIdEquipo());//aqui se los pasamos
            preparada.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlAlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
       ConnectionFactory.closeConnection();
    }
}
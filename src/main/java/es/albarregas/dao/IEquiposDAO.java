
package es.albarregas.dao;

import es.albarregas.beans.Equipo;
import java.util.ArrayList;

public interface IEquiposDAO {
    public void addEquipo(Equipo var1);

    public ArrayList<Equipo> getEquipos(String var1);

    public void updateEquipo(Equipo var1);

    public void deleteEquipos(String var1);

    public void closeConnection();
}
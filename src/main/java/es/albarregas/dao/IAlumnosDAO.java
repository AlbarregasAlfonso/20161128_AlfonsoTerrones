/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.beans.Alumno
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import java.util.ArrayList;

public interface IAlumnosDAO {
    public void addAlumno(Alumno var1);

    public ArrayList<Alumno> getAlumnos(String var1);

    public ArrayList<Alumno> getAlumnosEquipo();

    public void updateAlumno(Alumno var1);

    public void deleteAlumnos(String var1);
    
    public void deleteAlumnos2(String Where);

    public void closeConnection();
}
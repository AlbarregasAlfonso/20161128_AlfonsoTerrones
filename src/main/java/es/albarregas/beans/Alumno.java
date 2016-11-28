/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.beans.Equipo
 */
package es.albarregas.beans;

import es.albarregas.beans.Equipo;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String grupo;
    private Equipo equipo;

    public Alumno(int idAlumno, String nombre, String grupo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public Alumno() {
    }

    public Alumno(String nombre, String grupo, Equipo equipo) {
       
        this.nombre = nombre;
        this.grupo = grupo;
        this.equipo = equipo;
    }

    public int getIdAlumno() {
        return this.idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
/*
 * Decompiled with CFR 0_118.
 */
package es.albarregas.beans;

public class Equipo {
    private int idEquipo;
    private String marca;
    private String numSerie;

    public Equipo(int idEquipo, String marca, String numSerie) {
        this.idEquipo = idEquipo;
        this.marca = marca;
        this.numSerie = numSerie;
    }

    public Equipo() {
    }

     public Equipo(String marca, String numSerie) {
      
        this.marca = marca;
        this.numSerie = numSerie;
    }

   
   

    public int getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumSerie() {
        return this.numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
}
package clases;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class Articulo {
    int id;
  
    String resumen;
    String nombre_resumen;
    String estado;
    private ArrayList<Palabra> palabras;

    public Articulo(int id, String resumen, String nombre_resumen, String estado) {
        this.id = id;
        this.resumen = resumen;
        this.nombre_resumen = nombre_resumen;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getNombre_resumen() {
        return nombre_resumen;
    }

    public void setNombre_resumen(String nombre_resumen) {
        this.nombre_resumen = nombre_resumen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    

 
    
}

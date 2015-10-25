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
public class Revista {

    private int id;
    private String nombre;
    private ArrayList<Palabra> palabras;
    private ArrayList<Articulo> articulos;

    public Revista(int id, String nombre, ArrayList<Palabra> palabras, ArrayList<Articulo> articulos) {
        this.id = id;
        this.nombre = nombre;
        this.palabras = palabras;
        this.articulos = articulos;
    }

    public Revista() {
    }

    public Revista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }

    public void setPalabras(ArrayList<Palabra> palabras) {
        this.palabras = palabras;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

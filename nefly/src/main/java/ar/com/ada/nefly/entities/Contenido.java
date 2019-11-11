package ar.com.ada.nefly.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Contenido
 */
public class Contenido {

    @Id
    private ObjectId _id;
    private String nombre;
    private String genero;
    private int año;
    private double duracion;

    private List<Genero> generos = new ArrayList<Genero>();

    public Contenido() {
    }
    
    public Contenido(ObjectId _id, String nombre, String genero, int año, double duracion) {
        this._id = _id;
        this.nombre = nombre;
        this.genero = genero;
        this.año = año;
        this.duracion = duracion;
    }

    public Contenido(ObjectId _id, String nombre, String genero, int año) {
        this._id = _id;
        this.nombre = nombre;
        this.genero = genero;
        this.año = año;
    }
    
    public Contenido(List<Genero> generos) {
        this.generos = generos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

}
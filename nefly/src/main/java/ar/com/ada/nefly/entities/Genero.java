package ar.com.ada.nefly.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Genero
 */
@Document(collection = "Géneros")
public class Genero {

    private String nombre;

    public Genero() {
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
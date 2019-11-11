package ar.com.ada.nefly.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pelicula
 */
@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

    private boolean ganoOscar;

    public Pelicula() {
    }

    public Pelicula(ObjectId _id, String nombre, String genero, int año, int duracion) {
        super(_id, nombre, genero, año, duracion);
    }

    public Pelicula(List<Genero> generos) {
        super(generos);
    }

    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }

}
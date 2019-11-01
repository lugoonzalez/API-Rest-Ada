package ar.com.ada.nefly.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pelicula
 */
@Document(collection = "Peliculas")
public class Pelicula {

    public boolean ganoOscar;
}
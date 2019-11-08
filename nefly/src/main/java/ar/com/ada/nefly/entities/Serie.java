package ar.com.ada.nefly.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Serie
 */
@Document(collection = "Series")
public class Serie extends Contenido {

    public List<Temporada> temporadas = new ArrayList<Temporada>();

    public Serie() {
    }

    public Serie(ObjectId _id, String nombre, String genero, int año) {
        super(_id, nombre, genero, año);
    }

    public Temporada getTemporada(int nro) {

        for (Temporada tempo : this.temporadas) {
            if (tempo.nroTemporada == nro) {
                return tempo;
            }
        }
        return null;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

}
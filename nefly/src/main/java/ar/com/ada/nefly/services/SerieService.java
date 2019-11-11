package ar.com.ada.nefly.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nefly.entities.Serie;
import ar.com.ada.nefly.entities.Temporada;
import ar.com.ada.nefly.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository repoSerie;

    public void save(Serie serie){

        repoSerie.save(serie);
    }

    public Serie buscarPorId(int id) {

        Optional<Serie> u = repoSerie.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Serie buscarPorNombre(String nombre) {
        return repoSerie.findByNombre(nombre);
    }

    public List<Serie> getCatalogo() {
        return repoSerie.findAll();
    }

    public enum SerieValidationType {

        SERIE_OK,
        TEMPORADAS_NULA, 
        TEMPORADAS_VACIA, 
        TEMPORADA_DUPLICADA, 
        TEMPORADA_INVALIDA,

        SERIE_DATOS_INVALIDOS 
    }

    public SerieValidationType validarSerie(Serie serie){
        
        if (serie.getNombre() == null)
        return SerieValidationType.SERIE_OK;

        if (serie.getAño() <= 0)
        return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getTemporadas() == null)
        return SerieValidationType.TEMPORADAS_NULA;

        if (serie.getTemporadas().size() == 0)
        return SerieValidationType.TEMPORADAS_VACIA;
        
        HashMap<Integer, Temporada> unicasTemps = new HashMap<>();

        for (Temporada t : serie.getTemporadas()) {
            if (unicasTemps.containsKey(new Integer(t.getNroTemporada())))
            return SerieValidationType.TEMPORADA_DUPLICADA;
            if (t.getEpisodios().size() == 0)
            return SerieValidationType.TEMPORADA_INVALIDA;
    
        unicasTemps.put(new Integer(t.getNroTemporada()), t);
        }

        return SerieValidationType.SERIE_OK;
    }

}
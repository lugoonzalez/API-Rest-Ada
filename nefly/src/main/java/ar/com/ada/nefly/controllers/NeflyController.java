package ar.com.ada.nefly.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.nefly.entities.Episodio;
import ar.com.ada.nefly.entities.Pelicula;
import ar.com.ada.nefly.entities.Serie;
import ar.com.ada.nefly.entities.Temporada;
import ar.com.ada.nefly.models.response.ContenidoResponse;
import ar.com.ada.nefly.services.NeflyService;
import ar.com.ada.nefly.services.PeliculaService;
import ar.com.ada.nefly.services.SerieService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * NetflixController
 */
@RestController
public class NeflyController {

    @Autowired
    NeflyService neflyService;

    @Autowired
    SerieService serieService;

    @Autowired
    PeliculaService peliculaService;

    @PostMapping(value="/peliculas")
    public ContenidoResponse postNewPelicula(@RequestBody Pelicula p) {
    
        ContenidoResponse r = new ContenidoResponse();
        neflyService.cargarPelicula(p);

        r.message = "Pelicula cargada con éxito.";

        return r;
    }

    @PostMapping(value="/series")
    public ContenidoResponse postNewSerie(@RequestBody Serie s) {
    
        ContenidoResponse r = new ContenidoResponse();
        neflyService.cargarSerie(s);

        r.message = "Serie cargada con éxito.";

        return r;
    }

    @PostMapping(value="/series/{id}/temporadas")
    public ContenidoResponse postNewTemporada(@RequestBody Temporada t, @PathVariable String idSerie) {
    
        //ObjectId o = new ObjectId(idSerie);

        ContenidoResponse r = new ContenidoResponse();
        neflyService.cargarTemporada(idSerie, t);
        
        r.message = "Temporada cargada con éxito.";
        return r;
    }
    
    @PostMapping(value="/series/{id}/temporadas/{nroTemporada}/episodios")
    public ContenidoResponse postNewEpisodio(@RequestBody Episodio e, @PathVariable int nroTemporada, @PathVariable String idSerie) {
    
        ContenidoResponse r = new ContenidoResponse();
        neflyService.cargarEpisodio(idSerie, nroTemporada, e);
        
        r.message = "Episodio cargado con éxito.";
        return r;
    }
    

    
}
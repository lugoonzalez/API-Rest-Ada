package ar.com.ada.nefly.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nefly.entities.Episodio;
import ar.com.ada.nefly.entities.Pelicula;
import ar.com.ada.nefly.entities.Serie;
import ar.com.ada.nefly.entities.Temporada;
import ar.com.ada.nefly.repo.PeliculaRepository;
import ar.com.ada.nefly.repo.SerieRepository;

/**
 * NeflyService
 */
@Service
public class NeflyService {

    @Autowired
    PeliculaService peliculaService;
    @Autowired
    PeliculaRepository repoPelicula;
    
    @Autowired 
    SerieService serieService;
    @Autowired
    SerieRepository repoSerie;

    public Pelicula buscarPeli(String nombre) {
       return peliculaService.buscarPorNombre(nombre);      
    }

    
    public Serie buscarSerie(String nombre) {
        return serieService.buscarPorNombre(nombre);
    }

    /*public Pelicula cargarPelicula(String nombre, String genero, int año, int duracion, boolean ganoOscar){

        Pelicula p = new Pelicula();
        p.setNombre(nombre);
        p.setGenero(genero);
        p.setAño(año);
        p.setDuracion(duracion);
        p.setGanoOscar(ganoOscar);

        repoPelicula.save(p);
        return p;
    }

    public Serie cargarSerie(String nombre, String genero, int año){

        Serie s = new Serie();
        s.setNombre(nombre);
        s.setGenero(genero);
        s.setAño(año);
        
        repoSerie.save(s);
        return s;
    }*/

    public void cargarPelicula(Pelicula p){
        
        peliculaService.save(p);
    }

    public void cargarSerie(Serie s){

        serieService.save(s);
    }

    public void cargarTemporada(String idSerie, Temporada t){
        
       //ObjectId o = new ObjectId(idSerie);

        Serie s = repoSerie.findBy_id(new ObjectId(idSerie));

        s.temporadas.add(t);

        repoSerie.save(s);
    }

    public void cargarEpisodio(String idSerie, int nroTemporada, Episodio e){

        Serie s = repoSerie.findBy_id(new ObjectId(idSerie));

        Temporada t = s.getTemporada(nroTemporada);

        t.episodios.add(e);
    
        repoSerie.save(s);
    }
    
}
package ar.com.ada.nefly.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nefly.entities.Serie;
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

    
}
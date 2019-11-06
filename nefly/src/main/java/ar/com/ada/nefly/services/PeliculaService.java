package ar.com.ada.nefly.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nefly.entities.Pelicula;
import ar.com.ada.nefly.repo.PeliculaRepository;

/**
 * PeliculaService
 */
@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository repoPelicula;

    public void save(Pelicula pelicula){

        repoPelicula.save(pelicula);
    }

    public Pelicula buscarPorId(int id) {

        Optional<Pelicula> u = repoPelicula.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Pelicula buscarPorNombre(String nombre) {
        return repoPelicula.findByNombre(nombre);
    }

    public List<Pelicula> getCatalogo() {
        return repoPelicula.findAll();
    }

    
}
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

    public enum PeliculaValidationType {

        PELICULA_OK,
        PELICULA_DATOS_INVALIDOS,
        PELICULA_DURACION_INVALIDA,
        PELICULA_SIN_GENERO_AÑADIDO
    }

    public PeliculaValidationType validarPelicula(Pelicula pelicula){

        if (pelicula.getNombre() == null)
        return PeliculaValidationType.PELICULA_OK;

        if (pelicula.getAño() <= 0)
        return PeliculaValidationType.PELICULA_DATOS_INVALIDOS;

        if(pelicula.getDuracion() <=0.00 || pelicula.getDuracion() >=4.00)
        return PeliculaValidationType.PELICULA_DURACION_INVALIDA;

        if(pelicula.getGenero() != null)
        return PeliculaValidationType.PELICULA_SIN_GENERO_AÑADIDO;

        return PeliculaValidationType.PELICULA_OK;
    }
    
}
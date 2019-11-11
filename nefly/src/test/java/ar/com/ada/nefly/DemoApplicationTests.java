package ar.com.ada.nefly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.nefly.entities.Episodio;
import ar.com.ada.nefly.entities.Pelicula;
import ar.com.ada.nefly.entities.Serie;
import ar.com.ada.nefly.entities.Temporada;
import ar.com.ada.nefly.services.PeliculaService;
import ar.com.ada.nefly.services.SerieService;
import ar.com.ada.nefly.services.PeliculaService.PeliculaValidationType;
import ar.com.ada.nefly.services.SerieService.SerieValidationType;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	void verificarSerie() {

		SerieService service = new SerieService();

		Serie serie = new Serie();

		SerieValidationType validationType = service.validarSerie(serie);

		assertEquals(SerieValidationType.SERIE_DATOS_INVALIDOS, validationType);
	}

	void verificarPelicula() {

		PeliculaService service = new PeliculaService();
		
		Pelicula peli = new Pelicula();

		PeliculaValidationType validationType = service.validarPelicula(peli);

		assertEquals(PeliculaValidationType.PELICULA_DATOS_INVALIDOS, validationType);
	}

	@Test
	void verificarSerieTempDuplicada() {

		SerieService service = new SerieService();

		Serie serie = new Serie();
		serie.setNombre("How to Get Away with Murder");
		serie.setAño(2014);
		serie.setGenero("Drama legal");
		Temporada temporada = new Temporada();

		temporada.setNroTemporada(1);

		serie.getTemporadas().add(temporada);
		
		Episodio e = new Episodio();

		temporada.getEpisodios().add(e);
		
		Temporada temporada2 = new Temporada();

		temporada2.setNroTemporada(1);
		
		serie.getTemporadas().add(temporada2);
		
		e = new Episodio();

		temporada2.getEpisodios().add(e);
		
		SerieValidationType serieValidationType = service.validarSerie(serie);

		assertEquals(SerieValidationType.TEMPORADA_DUPLICADA, serieValidationType);
	}

	//void buscarGenerosMalAñadidos()
}

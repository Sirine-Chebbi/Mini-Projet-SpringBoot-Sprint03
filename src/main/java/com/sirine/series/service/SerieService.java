package com.sirine.series.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sirine.series.entities.Genre;
import com.sirine.series.entities.Serie;

public interface SerieService {
	
	Serie saveSerie(Serie s);
	Serie updateSerie(Serie s);
	void deleteSerie(Serie s);
	void deleteSerieById(Long idS);
	Serie getSerie(Long idS);
	List<Serie> getAllSeries();
	Page<Serie> getAllSeriesParPage(int page, int size);
	List<Serie> findByNomSerie(String nom);
	List<Serie> findByNomSerieContains(String nom);
	List<Serie> findByNomNb (String nom, Double nbs);
	List<Serie> findByGenre (Genre genre);
	List<Serie> findByGenreIdG(Long id);
	List<Serie> trierSeriesNomsNb();
	List<Serie> findByOrderByNomSerieAsc();
	List<Genre> getAllGenres();
}

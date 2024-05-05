package com.sirine.series.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sirine.series.entities.Genre;
import com.sirine.series.entities.Serie;
import com.sirine.series.repos.GenreRepository;
import com.sirine.series.repos.SerieRepository;

@Service
public class SerieServiceImpl implements SerieService{

	
	@Autowired
	SerieRepository serieRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public Serie saveSerie(Serie s) {
		return serieRepository.save(s);
	}

	@Override
	public Serie updateSerie(Serie s) {
		return serieRepository.save(s);

	}

	@Override
	public void deleteSerie(Serie s) {
		serieRepository.delete(s);
	}

	@Override
	public void deleteSerieById(Long idS) {
		serieRepository.deleteById(idS);
	}

	@Override
	public Serie getSerie(Long idS) {
		return serieRepository.findById(idS).get();
	}

	@Override
	public List<Serie> getAllSeries() {
		return serieRepository.findAll();
	}
	
	@Override
	public Page<Serie> getAllSeriesParPage(int page, int size) {
		return serieRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Serie> findByNomSerie(String nom) {
	return serieRepository.findByNomSerie(nom);
	}
	
	@Override
	public List<Serie> findByNomSerieContains(String nom) {
	return serieRepository.findByNomSerieContains(nom);
	}
	
	@Override
	public List<Serie> findByNomNb(String nom, Double prix) {
	return serieRepository.findByNomNbSaison(nom, prix);
	}
	
	@Override
	public List<Serie> findByGenre(Genre genre) {
	return serieRepository.findByGenre(genre);
	}
	
	@Override
	public List<Serie> findByGenreIdG(Long id) {
	return serieRepository.findByGenreIdG(id);
	}
	
	@Override
	public List<Serie> findByOrderByNomSerieAsc() {
	return serieRepository.findByOrderByNomSerieAsc();
	}
	
	@Override
	public List<Serie> trierSeriesNomsNb() {
	return serieRepository.trierSeriesNomsNb();
	}
	
	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}
}

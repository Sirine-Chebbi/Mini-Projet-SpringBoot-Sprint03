package com.sirine.series;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.sirine.series.entities.Genre;
import com.sirine.series.entities.Serie;
import com.sirine.series.repos.SerieRepository;
import com.sirine.series.service.SerieService;

@SpringBootTest
class SeriesApplicationTests {

	@Autowired
	private SerieRepository serieRepository;
	
	
	@Autowired
	SerieService serieService;
	
	 @Test
	 public void testFindByNomSerie()
	 {
		 List<Serie> series = serieRepository.findByNomSerie("Bridgerton");
		 for (Serie s : series)
		 {
			 System.out.println(s);
		 }
	 }
	@Test
	public void testFindByNomSerieContains()
	{
		List<Serie> series=serieRepository.findByNomSerieContains("Brid");
		for (Serie s : series)
		{
		System.out.println(s);
		} 
	}
	
	@Test
	public void testCreateSerie() {
		Serie series = new Serie("Eve",1.0,new Date());
		serieRepository.save(series);
	}
	
	@Test
	public void testFindSerieById()
	{
		Serie s = serieRepository.findById(2L).get();
		System.out.println(s);
	}
	
	@Test
	public void testUpdateSerie()
	{
		Serie s = serieRepository.findById(1L).get();
		s.setNbSerie(2.0);
		serieRepository.save(s);
	
		System.out.println(s);
	}
	
	@Test
	public void testDeleteSerie()
	{
		serieRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllSeries()
	{
		List<Serie> series = serieRepository.findAll();
		
		for (Serie s:series)
			 System.out.println(s);
		
	}
	
	@Test
	public void testfindByNomNbSaison() {
		List<Serie> series = serieRepository.findByNomNbSaison("Eve",1.0);
		for (Serie s : series)
			System.out.println(s);
	}
	
	@Test
	public void testfindByCategorie()
	{
		Genre genre = new Genre();
		genre.setIdG(1L);
		List<Serie> series = serieRepository.findByGenre(genre);
		for (Serie s : series)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void findByGenreIdGIdCat()
	{
		List<Serie> series = serieRepository.findByGenreIdG(1L);
		for (Serie s : series)
		{
			System.out.println(s);
		}
	 }
	
	@Test
	public void testfindByOrderByNomProduitDesc()
	{
		List<Serie> series =serieRepository.findByOrderByNomSerieAsc();
		for (Serie s : series)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Serie> series = serieRepository.trierSeriesNomsNb();
		for (Serie s : series)
		{
			System.out.println(s);
		}
	}

}

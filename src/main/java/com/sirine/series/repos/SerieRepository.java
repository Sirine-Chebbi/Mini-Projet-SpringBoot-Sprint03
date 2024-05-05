package com.sirine.series.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sirine.series.entities.Genre;
import com.sirine.series.entities.Serie;

@RepositoryRestResource(path = "rest")
public interface SerieRepository extends JpaRepository<Serie, Long> {
	
	List<Serie> findByNomSerie(String nom);
	List<Serie> findByNomSerieContains(String nom);
	
	@Query("select s from Serie s where s.nomSerie like %:nom and s.nbSerie > :nbs")
	List<Serie> findByNomNbSaison (@Param("nom") String nom,@Param("nbs") Double nbs);
	
	@Query("select s from Serie s where s.genre = ?1")
	List<Serie> findByGenre (Genre genre);
	
	List<Serie> findByGenreIdG(Long id);
	List<Serie> findByOrderByNomSerieAsc();
	
	@Query("select s from Serie s order by s.nomSerie ASC, s.nbSerie ASC")
	List<Serie> trierSeriesNomsNb ();
}

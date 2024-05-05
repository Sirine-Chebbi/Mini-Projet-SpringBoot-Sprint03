package com.sirine.series.entities;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;



@Entity
public class Serie {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSerie;
	
	@NotNull
	@Size (min = 2,max = 50)
	private String nomSerie;
	
	@Min(value = (long) 1.0)
	@Max(value = (long) 10.0)
	private Double nbSerie;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateSortie;

	@ManyToOne
	private Genre genre;
	
	public Serie() {
		super();
	}
	
	public Serie(String nomSerie, Double nbS, Date dateSortie) {
		super();
		this.nomSerie = nomSerie;
		this.nbSerie = nbS;
		this.dateSortie = dateSortie;
	}


	


	public Long getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}

	public String getNomSerie() {
		return nomSerie;
	}

	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}

	public Double getNbSerie() {
		return nbSerie;
	}

	public void setNbSerie(Double nbSerie) {
		this.nbSerie = nbSerie;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Serie [idSerie=" + idSerie + ", nomSerie=" + nomSerie + ", nbSerie=" + nbSerie + ", dateSortie="
				+ dateSortie + "]";
	}

	

	

}
	
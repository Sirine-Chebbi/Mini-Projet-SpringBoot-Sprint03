package com.sirine.series.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirine.series.entities.Serie;
import com.sirine.series.entities.Genre;
import com.sirine.series.service.SerieService;

import jakarta.validation.Valid;

@Controller
public class SerieController {

	@Autowired
	SerieService serieService;

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
	
	@RequestMapping("/ListeSeries")
	public String listeSeries(ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "3") int size) {
		Page<Serie> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		 modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeSeries";
	}

	@RequestMapping("/saveSerie")
	public String saveSerie(@Valid Serie serie,BindingResult bindingResult, @RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "3") int size){
			int currentPage;
			boolean isNew = false;
			if (bindingResult.hasErrors()) return "formSerie";
			if (serie.getIdSerie()==null) //ajout
			isNew=true;
			serieService.saveSerie(serie);
			if (isNew) //ajout
			{
			Page<Serie> series = serieService.getAllSeriesParPage(page, size);
			currentPage = series.getTotalPages()-1;
			}
			else //modif
			currentPage=page;
			return ("redirect:/ListeSeries?page="+currentPage+"&size="+size);
			}

	@RequestMapping("/supprimerSerie")
	public String supprimerSerie(@RequestParam Long id, ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "3") int size) {
		serieService.deleteSerieById(id);
		Page<Serie> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeSeries";
	}
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Genre> genres = serieService.getAllGenres();
		modelMap.addAttribute("serie", new Serie());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("genres", genres);
		return "formSerie";
	} 

	@RequestMapping("/modifierSerie")
	public String editerSerie(@RequestParam("id") Long id, ModelMap modelMap) {
		Serie s = serieService.getSerie(id);
		List<Genre> genres = serieService.getAllGenres();
		modelMap.addAttribute("serie", s);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("genres", genres);
		return "formSerie";
	}

	@RequestMapping("/updateSerie")
	public String updateSerie(@ModelAttribute("serie") Serie serie, @RequestParam String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateSortie = dateformat.parse(String.valueOf(date));
		serie.setDateSortie(dateSortie);

		serieService.updateSerie(serie);
		List<Serie> series = serieService.getAllSeries();
		modelMap.addAttribute("series", series);
		return "listeSeries";
	}
}

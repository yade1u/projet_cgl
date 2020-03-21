package com.yade_sahoh_taleb.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yade_sahoh_taleb.hibernatedemo.models.GenreJeu;
import com.yade_sahoh_taleb.hibernatedemo.services.GenreJeuService;

import javax.servlet.http.HttpServletRequest;

//@RestController
@Controller
//@RequestMapping("genres")
public class GenreJeuController {
	
	private final GenreJeuService genreJeuService;
	
	@Autowired
	public GenreJeuController(GenreJeuService genreJeuService) {
		this.genreJeuService = genreJeuService;
	}
	
	/**
	 * La liste des genres
	 * @return List<GenreJeu>
	 */
	@GetMapping("/genres")
	public /*List<GenreJeu>*/ String getGenreJeux(HttpServletRequest request, ModelMap model) {

			Iterable<GenreJeu> genreJeux = genreJeuService.getGenreJeux();
			model.put("genreJeux", genreJeux);
			return "genreJeuxList";

			//return genreJeuService.getGenreJeux();
	}
	
	/**
	 * Créer un genre
	 */
	@PostMapping("genres")
	public void creerOuModifierGenre(GenreJeu genreJeu) {
		this.genreJeuService.saveOrUpdate(genreJeu);
	}
	
	/**
	 * Supprimer un genre
	 */
	@DeleteMapping("/genres/{genreId}")
	public void supprimerGenre(int id) {
		this.genreJeuService.deleteGenreJeu(id);
	}

}

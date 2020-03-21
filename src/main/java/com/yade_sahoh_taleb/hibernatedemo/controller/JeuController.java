package com.yade_sahoh_taleb.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yade_sahoh_taleb.hibernatedemo.models.Jeu;
import com.yade_sahoh_taleb.hibernatedemo.services.JeuService;

@RestController
@RequestMapping("jeux")
public class JeuController {

	private final JeuService jeuService;
	
	@Autowired
	public JeuController(JeuService jeuService) {
		this.jeuService = jeuService;
	}
	
	/**
	 * La liste des jeux 
	 * @return List<Jeu>
	 */
	@PostMapping("/jeux")
	public List<Jeu> getGenreJeux(int idType, int idGenre, int idTheme, int nbJMin, int nbJMax, int ageMin, int idEditeur) {
		return jeuService.getJeuxByFiltre(idType, idGenre, idTheme, nbJMin, nbJMax, ageMin, idEditeur);
	}
	
	/**
	 * Supprimer jeux associé à un éditeur
	 */
	@DeleteMapping("/genres")
	public void supprimerGenre(int idEditeur) {
		this.jeuService.deleteJeuxByIdEditeur(idEditeur);
	}
}

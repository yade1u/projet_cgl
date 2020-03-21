package com.yade_sahoh_taleb.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yade_sahoh_taleb.hibernatedemo.models.ThemeJeu;
import com.yade_sahoh_taleb.hibernatedemo.services.ThemeJeuService;

@RestController
@RequestMapping("themes")
public class ThemeJeuController {

	private final ThemeJeuService themeJeuService;
	
	@Autowired
	public ThemeJeuController(ThemeJeuService themeJeuService) {
		this.themeJeuService = themeJeuService;
	}
	
	/**
	 * La liste des thèmes
	 * @return List<ThemeJeu>
	 */
	@GetMapping("/themes")
	public List<ThemeJeu> getThemeJeux() {
		return themeJeuService.getThemeJeux();
	}
	
	/**
	 * Créer un thème
	 */
	@PostMapping("themes")
	public void creerOuModifierTheme(ThemeJeu themeJeu) {
		this.themeJeuService.saveOrUpdate(themeJeu);
	}
	
	/**
	 * Supprimer un thème
	 */
	@DeleteMapping("/themes/{themeId}")
	public void supprimerTheme(int id) {
		this.themeJeuService.deleteThemeJeu(id);
	}
}

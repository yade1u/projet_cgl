package com.yade_sahoh_taleb.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yade_sahoh_taleb.hibernatedemo.models.TypeJeu;
import com.yade_sahoh_taleb.hibernatedemo.services.TypeJeuService;

@RestController
@RequestMapping("types")
public class TypeJeuController {

private final TypeJeuService typeJeuService;
	
	@Autowired
	public TypeJeuController(TypeJeuService typeJeuService) {
		this.typeJeuService = typeJeuService;
	}
	
	/**
	 * La liste des types
	 * @return List<TypeJeu>
	 */
	@GetMapping("/types")
	public List<TypeJeu> getTypeJeux() {
		return typeJeuService.getTypeJeux();
	}
	
	/**
	 * Créer un type
	 */
	@PostMapping("types")
	public void creerOuModifierType(TypeJeu typeJeu) {
		this.typeJeuService.saveOrUpdate(typeJeu);
	}
	
	/**
	 * Supprimer un type
	 */
	@DeleteMapping("/types/{typeId}")
	public void supprimerType(int id) {
		this.typeJeuService.deleteTypeJeu(id);
	}
}

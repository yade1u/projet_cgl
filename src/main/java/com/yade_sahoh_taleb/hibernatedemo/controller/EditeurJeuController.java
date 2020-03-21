package com.yade_sahoh_taleb.hibernatedemo.controller;

/*import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;*/
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.yade_sahoh_taleb.hibernatedemo.models.EditeurJeu;
import com.yade_sahoh_taleb.hibernatedemo.services.EditeurJeuService;
import com.yade_sahoh_taleb.hibernatedemo.services.JeuService;

import java.util.List;

@RestController
@RequestMapping("editeurs")
public class EditeurJeuController {

	private final EditeurJeuService editeurJeuService;
	private final JeuService jeuService;
	
	@Autowired
	public EditeurJeuController(EditeurJeuService editeurJeuService, JeuService jeuService) {
		this.editeurJeuService = editeurJeuService;
		this.jeuService = jeuService;
	}
	
	@GetMapping("/editeurs")
	public List<EditeurJeu> getEditeurJeux() {
		return editeurJeuService.getEditeurJeux();
	}
	
	/**
	 * Créer un éditeur
	 */
	@PostMapping("editeurs")
	public void creerOuModifierEditeur(EditeurJeu editeurJeu) {
		this.editeurJeuService.saveOrUpdate(editeurJeu);
	}
	
	/**
	 * Supprimer un éditeur
	 * Un éditeur supprimé, supprimera tous les jeux associés à ce éditeur
	 */
	@DeleteMapping("/editeurs/{editeurId}")
	public void supprimerEditeur(int id) {
		//Gérer d'abord la suppression des jeux associés
		this.jeuService.deleteJeuxByIdEditeur(id);
		
		//Supprimer l'éditeur
		this.editeurJeuService.deleteEditeurJeu(id);
	}
	
}

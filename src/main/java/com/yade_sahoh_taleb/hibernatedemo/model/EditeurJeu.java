package com.yade_sahoh_taleb.hibernatedemo.model;

import javax.persistence.*;

@Entity
@Table(name = "editeur_jeu")
public class EditeurJeu extends CreatUpdateAt {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;
	
	@Basic(optional = false)
    private String nom_editeur;
	
	public EditeurJeu(String nom_editeur) {
		this.nom_editeur = nom_editeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_editeur() {
		return nom_editeur;
	}

	public void setNom_editeur(String nom_editeur) {
		this.nom_editeur = nom_editeur;
	}

	
}

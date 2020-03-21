package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.models.Jeu;
import com.yade_sahoh_taleb.hibernatedemo.repositories.JeuRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JeuService {

  @Autowired
  JeuRepository jeuRepository;
  
  /**
   * Recupèrer les jeux correspondant aux filtres sur :
   * 	- type
   * 	- genre
   * 	- theme
   * 	- nombre de joueurs (max et min)
   * 	- age minimum conseillé
   * 	- editeur
   * 
   * Afficher ces jeux avec leurs notes triés par ordre décroissant
   * 
   */
  public List<Jeu> getJeuxByFiltre(int idType, int idGenre, int idTheme, int nbJMin, int nbJMax, int ageMin, int idEditeur) {
	  return jeuRepository.findByTypeGenreThemeNbJMinNbJMaxAgeMinEditeur(idType, idGenre, idTheme, nbJMin, nbJMax, ageMin, idEditeur);
  }
  
  
  /**
   * Supprimer les jeux associés à un éditeur
   */
  public void deleteJeuxByIdEditeur(int idEditeur) {
	  jeuRepository.deleteByIdEditeur(idEditeur);
  }
}

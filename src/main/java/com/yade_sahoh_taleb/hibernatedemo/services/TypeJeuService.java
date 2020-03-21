package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.models.TypeJeu;
import com.yade_sahoh_taleb.hibernatedemo.repositories.TypeJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TypeJeuService {
  @Autowired
  TypeJeuRepository typeJeuRepository;

  /**
   * Récuperer tous les Types de jeu.
   * @return liste des Types jeux.
   **/

  public List<TypeJeu> getTypeJeux() {
    List<TypeJeu> typeJeux = new ArrayList<>();
    typeJeuRepository.findAll().forEach(typeJeu -> typeJeux.add(typeJeu));
    return typeJeux;
  }

  /**
   * Récuperer une entité d un Type de jeu.
   * @param id  de Type jeu.
   * @return une entite de type TypeJeu.
   */
  public TypeJeu getTypeById(int id) {
    Optional<TypeJeu> optionalTypeJeu = typeJeuRepository.findById(id);
    if (optionalTypeJeu.isPresent()) {
      return optionalTypeJeu.get();
    }
    return null;
  }

  /**
   * Sauvegarder ou mettre à jour un typeJeu.
   * @param typeJeu une entite de type typeJeu.
   */
  public void saveOrUpdate(TypeJeu typeJeu) {
    typeJeuRepository.save(typeJeu);
  }

  /**
   * Supprimer un type ne supprime pas les jeux associé
   * supprimer un type Jeu .
   * @param id long: l´identifiant de la entité.
   */
  public void deleteTypeJeu(int id) {
    typeJeuRepository.deleteById(id);
  }
}

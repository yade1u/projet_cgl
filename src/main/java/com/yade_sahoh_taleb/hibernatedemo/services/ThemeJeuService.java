package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.models.ThemeJeu;
import com.yade_sahoh_taleb.hibernatedemo.repositories.ThemeJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThemeJeuService {

  @Autowired
  ThemeJeuRepository themeJeuRepository;

  /**
   * Récuperer tous les themes de jeu.
   * @return liste des themes jeux.
   **/

  public List<ThemeJeu> themeJeux() {
    List<ThemeJeu> themeJeux = new ArrayList<>();
    themeJeuRepository.findAll().forEach(themeJeu -> themeJeux.add(themeJeu));
    return themeJeux;
  }

  /**
   * Récuperer une entité d un theme de jeu.
   * @param id  de theme jeu.
   * @return une entite de type ThemeJeu.
   */
  public ThemeJeu getMeteoById(int id) {
    Optional<ThemeJeu> optionalThemeJeu = themeJeuRepository.findById(id);
    if (optionalThemeJeu.isPresent()) {
      return optionalThemeJeu.get();
    }
    return null;
  }

  /**
   * Sauvegarder ou mettre à jour un themeJeu.
   * @param themeJeu une entite de type themeJeu.
   */
  public void saveOrUpdate(ThemeJeu themeJeu) {
    themeJeuRepository.save(themeJeu);
  }

  /**
   * supprimer un theme Jeu .
   * @param id long: l´identifiant de la entité.
   */
  public void deleteThemeJeu(int id) {
    themeJeuRepository.deleteById(id);
  }


}

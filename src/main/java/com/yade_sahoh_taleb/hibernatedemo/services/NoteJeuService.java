package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.models.NoteJeu;
import com.yade_sahoh_taleb.hibernatedemo.repositories.NoteJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoteJeuService {

  @Autowired
  NoteJeuRepository noteJeuRepository;

  /**
   * Récuperer tous les Notes de jeu.
   * @return liste des NoteJeu.
   **/

  public List<NoteJeu> NoteJeux() {
    List<NoteJeu> noteJeux = new ArrayList<>();
    noteJeuRepository.findAll().forEach(noteJeu -> noteJeux.add(noteJeu));
    return noteJeux;
  }

  /**
   * Récuperer une entité d un note de jeu.
   * @param id  de note jeu.
   * @return une entite de type NoteJeu.
   */
  public NoteJeu getMeteoById(int id) {
    Optional<NoteJeu> optionalNote = noteJeuRepository.findById(id);
    if (optionalNote.isPresent()) {
      return optionalNote.get();
    }
    return null;
  }

  /**
   * Sauvegarder ou mettre à jour un noteJeu.
   * @param noteJeu une entite de type NoteJeu.
   */
  public void saveOrUpdate(NoteJeu noteJeu) {
    noteJeuRepository.save(noteJeu);
  }

  /**
   * supprimer une note Jeu .
   * @param id long: l´identifiant de la entité.
   */
  public void deleteNoteJeu(int id) {
    noteJeuRepository.deleteById(id);
  }

}

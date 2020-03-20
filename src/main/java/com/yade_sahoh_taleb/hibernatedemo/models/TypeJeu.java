package com.yade_sahoh_taleb.hibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "type_jeu")
public class TypeJeu {

  @Id
  @GeneratedValue
  @Column
  @JsonProperty("id")
  private int id;

  @Column
  @JsonProperty("nom_type")
  private String nom_type;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom_type() {
    return nom_type;
  }

  public void setNom_type(String nom_type) {
    this.nom_type = nom_type;
  }
}

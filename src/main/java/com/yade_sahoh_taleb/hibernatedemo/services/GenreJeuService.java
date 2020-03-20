package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.repositories.GenreJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreJeuService {

  @Autowired
  GenreJeuRepository genreJeuRepository;
}

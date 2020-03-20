package com.yade_sahoh_taleb.hibernatedemo.repositories;

import com.yade_sahoh_taleb.hibernatedemo.models.GenreJeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreJeuRepository extends JpaRepository<GenreJeu,Integer> {
}

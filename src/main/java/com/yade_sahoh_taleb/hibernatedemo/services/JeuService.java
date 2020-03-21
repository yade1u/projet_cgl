package com.yade_sahoh_taleb.hibernatedemo.services;

import com.yade_sahoh_taleb.hibernatedemo.repositories.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JeuService {

  @Autowired
  JeuRepository jeuRepository;
}

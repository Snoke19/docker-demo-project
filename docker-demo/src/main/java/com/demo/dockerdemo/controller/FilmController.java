package com.demo.dockerdemo.controller;

import com.demo.dockerdemo.repository.FilmRepository;
import com.demo.dockerdemo.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

  private final FilmRepository filmRepository;

  public FilmController(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @GetMapping("/films")
  public List<Film> getActors() {
    return this.filmRepository.findAll();
  }
}

package com.demo.dockerdemo.controller;

import com.demo.dockerdemo.repository.FilmRepository;

import lombok.extern.slf4j.Slf4j;

import com.demo.dockerdemo.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FilmController {

  private final FilmRepository filmRepository;

  public FilmController(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @GetMapping("/films")
  public List<Film> getActors() {

    List<Film> films = this.filmRepository.findAll();
      
    log.info("Get all films. size: {}", films.size());

    return films;
  }
}
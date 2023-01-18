package com.demo.dockerdemo.controller;

import com.demo.dockerdemo.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import com.demo.dockerdemo.dto.FilmDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FilmController {

  private final FilmService filmService;

  public FilmController(FilmService filmService) {
    this.filmService = filmService;
  }

  @GetMapping("/films")
  public List<FilmDto> getActors() {

    List<FilmDto> films = this.filmService.getFilms();
      
    log.info("Get all films. size: {}", films.size());

    return films;
  }
}
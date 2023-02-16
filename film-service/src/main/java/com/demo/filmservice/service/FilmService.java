package com.demo.filmservice.service;

import java.util.List;

import com.demo.filmservice.dto.FilmDto;

public interface FilmService {

  List<FilmDto> getFilms();
}

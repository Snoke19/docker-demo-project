package com.demo.dockerdemo.service;

import java.util.List;

import com.demo.dockerdemo.dto.FilmDto;

public interface FilmService {

  List<FilmDto> getFilms();
}

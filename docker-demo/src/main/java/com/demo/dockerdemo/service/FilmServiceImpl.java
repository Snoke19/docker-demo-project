package com.demo.dockerdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.dockerdemo.dto.FilmDto;
import com.demo.dockerdemo.dto.LanguageDto;
import com.demo.dockerdemo.model.Film;
import com.demo.dockerdemo.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;
  private final RestTemplate restTemplateDockerDemo2;

  public FilmServiceImpl(FilmRepository filmRepository, RestTemplate restTemplateDockerDemo2) {
    this.filmRepository = filmRepository;
    this.restTemplateDockerDemo2 = restTemplateDockerDemo2;
  }

  @Override
  public List<FilmDto> getFilms() {
    
    List<Film> films = this.filmRepository.findAll();

    return films.stream().map(data -> {
      return FilmDto.builder()
      .idFilm(data.getId())
      .name(data.getTitle())
      .description(data.getDescription())
      .language(findLanguageById(data.getLanguageId()))
      .build();
    }).collect(Collectors.toList());
  }
  

  private LanguageDto findLanguageById(long idLanguage) {

  
    List<LanguageDto> languages = this.restTemplateDockerDemo2.exchange(
      "/languages",
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<LanguageDto>>() {})
    .getBody();

    for (int i = 0; i < languages.size(); i++) {
      if(languages.get(i).getId() == idLanguage) {
        return languages.get(i);
      }
    }

    return null;
  }
}

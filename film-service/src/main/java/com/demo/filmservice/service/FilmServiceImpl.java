package com.demo.filmservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.filmservice.dto.FilmDto;
import com.demo.filmservice.dto.ReviewDto;
import com.demo.filmservice.model.Film;
import com.demo.filmservice.repository.FilmRepository;

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

    return films.stream().map(data ->
      FilmDto.builder()
        .idFilm(data.getId())
        .name(data.getTitle())
        .description(data.getDescription())
        .review(findReviewById(data.getReviewId()))
        .build()
    ).collect(Collectors.toList());
  }


  private ReviewDto findReviewById(long id) {

    Map<String, Long> requestParams = new HashMap<>();
    requestParams.put("id", id);

    ReviewDto review = this.restTemplateDockerDemo2.getForObject("/review", ReviewDto.class, requestParams);

    return review == null ? new ReviewDto() : review;
  }
}

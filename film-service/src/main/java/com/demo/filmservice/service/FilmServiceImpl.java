package com.demo.filmservice.service;

import com.demo.filmservice.Film;
import com.demo.filmservice.FilmRepository;
import com.demo.filmservice.dto.FilmDto;
import com.demo.filmservice.dto.ReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    UriComponents uriComponents = UriComponentsBuilder
      .fromUriString("/review")
      .queryParam("id", id)
      .encode()
      .build();

    ReviewDto review = this.restTemplateDockerDemo2.getForObject(uriComponents.toUri().toString(), ReviewDto.class);

    return review == null ? new ReviewDto() : review;
  }
}

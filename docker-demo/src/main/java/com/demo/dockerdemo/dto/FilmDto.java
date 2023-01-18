package com.demo.dockerdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
  
  private long idFilm;
  private String name;
  private String description;
  private LanguageDto language;
}

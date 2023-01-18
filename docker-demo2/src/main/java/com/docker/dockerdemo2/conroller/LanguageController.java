package com.docker.dockerdemo2.conroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.dockerdemo2.model.Language;
import com.docker.dockerdemo2.repository.LanguageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LanguageController {

  private final LanguageRepository languageRepository;

  public LanguageController(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  @GetMapping("/languages")
  public List<Language> getLanguages() {

    List<Language> languages = this.languageRepository.findAll();
      
    log.info("Get all languages. size: {}", languages.size());

    return languages;
  }
  
}
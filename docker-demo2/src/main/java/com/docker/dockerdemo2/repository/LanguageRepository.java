package com.docker.dockerdemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.dockerdemo2.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
  
}

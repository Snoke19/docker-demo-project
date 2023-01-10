package com.demo.dockerdemo.repository;


import com.demo.dockerdemo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

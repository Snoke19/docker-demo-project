package com.demo.dockerdemo;


import com.demo.dockerdemo.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}

package com.demo.dockerdemo;

import com.demo.dockerdemo.model.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

  private final ActorRepository actorRepository;

  public ActorController(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }

  @GetMapping("/users")
  public List<Actor> getActors() {
    return this.actorRepository.findAll();
  }

  @PostMapping("/user")
  public void saveActor(@RequestBody ActorCreation actorCreation) {

    this.actorRepository.save(Actor.builder().givenName(actorCreation.getName()).familyName(actorCreation.getSecondName()).build());
  }
}

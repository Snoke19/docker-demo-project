package com.demo.reviewservice.conroller;

import com.demo.reviewservice.model.ReviewDto;
import com.demo.reviewservice.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReviewController {

  private final ReviewRepository reviewRepository;

  public ReviewController(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @GetMapping("/review")
  public ReviewDto getLanguages(@RequestParam("id") long reviewId) {

    ReviewDto review = this.reviewRepository.findById(reviewId);
      
    log.info("Get all languages. {}", review);

    return review;
  }
  
}
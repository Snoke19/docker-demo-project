package com.demo.reviewservice.model;

import lombok.Data;

@Data
public class ReviewDto {

  private long id;
  private String review;
  private int rating;
}
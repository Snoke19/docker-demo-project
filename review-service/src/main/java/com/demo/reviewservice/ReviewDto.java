package com.demo.reviewservice;

import lombok.Data;

@Data
public class ReviewDto {

  private long id;
  private String review;
  private int rating;
}
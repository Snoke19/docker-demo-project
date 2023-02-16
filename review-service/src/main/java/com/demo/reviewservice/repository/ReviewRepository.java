package com.demo.reviewservice.repository;

import com.demo.reviewservice.model.ReviewDto;

import java.util.List;

public interface ReviewRepository {

  ReviewDto findById(long reviewId);
}

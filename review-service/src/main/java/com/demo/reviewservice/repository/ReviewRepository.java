package com.demo.reviewservice.repository;

import com.demo.reviewservice.ReviewDto;

public interface ReviewRepository {

  ReviewDto findById(long reviewId);
}

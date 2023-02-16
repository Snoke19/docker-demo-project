package com.demo.reviewservice.repository;

import com.demo.reviewservice.conroller.RecordNotFoundException;
import com.demo.reviewservice.model.ReviewDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {

  @Override
  public ReviewDto findById(long reviewId) {

    try {
      CSVReader reader = new CSVReader(new FileReader("./review-service/reviews.csv"));

      while (reader.readNext() != null) {
        String[] record = reader.readNext();
        System.out.println(Arrays.toString(record));
        if (Long.parseLong(record[0]) == reviewId) {
          ReviewDto review = new ReviewDto();
          review.setId(Long.parseLong(record[0]));
          review.setReview(record[1]);
          review.setRating(Integer.parseInt(record[2]));

          return review;
        }
      }

    } catch (IOException | CsvException e) {
      System.out.println(e.getMessage());
      throw new RecordNotFoundException(e);
    }

    return null;
  }
}

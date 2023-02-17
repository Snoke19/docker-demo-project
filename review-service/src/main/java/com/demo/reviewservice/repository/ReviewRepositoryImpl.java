package com.demo.reviewservice.repository;

import com.demo.reviewservice.conroller.RecordNotFoundException;
import com.demo.reviewservice.model.ReviewDto;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {

  @Override
  public ReviewDto findById(long reviewId) {

    try {

      CSVParser csvParser = new CSVParserBuilder()
        .withSeparator(',')
        .withIgnoreQuotations(true)
        .build();
      CSVReader reader = new CSVReaderBuilder(new FileReader("reviews.csv"))
        .withCSVParser(csvParser)
        .build();

      String[] record;
      while ((record = reader.readNext()) != null) {
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

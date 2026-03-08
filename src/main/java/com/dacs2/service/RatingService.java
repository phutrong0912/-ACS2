package com.dacs2.service;

import com.dacs2.model.Product;
import com.dacs2.model.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getRatingsByProductId(Product product);

    Integer count(Product product, Integer rating);

}

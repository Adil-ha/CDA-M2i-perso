package com.example.candy_shop_data_rest.repository;

import com.example.candy_shop_data_rest.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByCandyId(Long candyId);
}

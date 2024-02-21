package com.example.candy_shop_data_rest.repository;

import com.example.candy_shop_data_rest.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface CandyRepository extends CrudRepository<Candy, Long> {
    List<Candy> findAllByName(String name);
    List<Candy> findAllByMagicalEffect(String magicalEffect);
    List<Candy> findAllByPriceBetween(double minPrice, double maxPrice);
}

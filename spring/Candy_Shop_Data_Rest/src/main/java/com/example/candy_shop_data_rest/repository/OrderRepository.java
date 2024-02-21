package com.example.candy_shop_data_rest.repository;

import com.example.candy_shop_data_rest.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface OrderRepository extends CrudRepository<Order, Long> {
}

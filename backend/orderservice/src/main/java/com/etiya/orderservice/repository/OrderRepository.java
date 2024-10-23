package com.etiya.orderservice.repository;

import com.etiya.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID>
{
    // Klasik repository kuralları geçerli
/*    Order findByTotalPrice(float totalPrice);*/
}
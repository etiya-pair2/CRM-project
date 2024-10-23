package com.etiya.orderservice.repository;

import com.etiya.orderservice.entity.OrderOfferDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderOfferDetailRepository extends MongoRepository<OrderOfferDetail, UUID> {

}

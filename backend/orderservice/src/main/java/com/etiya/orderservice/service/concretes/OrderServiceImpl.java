package com.etiya.orderservice.service.concretes;

import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.order.*;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.mapper.OrderMapper;
import com.etiya.orderservice.repository.OrderRepository;
import com.etiya.orderservice.service.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Override
    public List<GetAllOrderResponse> getAll() {
        return orderMapper.orderFromGetAllResponse(orderRepository.findAll());
    }

    @Override
    public CreateOrderResponse create(CreateOrderRequest request) {
        Order order = orderRepository.save(orderMapper.orderFromCreateRequest(request));
        return orderMapper.orderFromCreateResponse(order);
    }

    @Override
    public UpdateOrderResponse update(UpdateOrderRequest request) {
        Order order = orderRepository.save(orderMapper.orderFromUpdateRequest(request));
        return orderMapper.orderFromUpdateResponse(order);
    }


    @Override
    public DeleteOrderResponse delete(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
        orderRepository.deleteById(id);
        return orderMapper.orderFromDeleteResponse(order);
    }

    @Override
    public GetByIdOrderResponse getById(UUID id) {
        return orderRepository.findById(id)
                .map(orderMapper::orderFromGetByIdResponse)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }


//    @Override
//    public void add(CreateOrderRequest createOrderRequest) {
///*        // Customer bilgileri
//
//
//        List<Product> response = productServiceClient.findAllByIds(
//                createOrderRequest.getProducts().stream().map(ProductForOrderDto::getProductId).toList()
//        );
//
//        //TODO: Refactor as business rules.
//        // OrderBusinessRules.AllProductsShouldExist()
//        if(response.size() != createOrderRequest.getProducts().size()) //
//        {
//            // Ürün sayısı uyuşmuyor..
//        }
//        // 293 -> 5 adet istenmiş stok yeterli mi?
//        Order order = new Order();
//        order.setOrderDate(LocalDate.now());
//        order.setCustomerId(createOrderRequest.getCustomerId());
//        order.setProducts(response);
//        orderRepository.save(order); // Sipariş alındı.
//
//        // Diğer 5 servis bir işlem yapacak..
//        // Kafka -> NewOrderCreated -> { id:1, customerId:2, products:[] }
//        // Subscriber-(Consumer) -> NewOrderCreated kafkada ne zaman oluşturulsa ben onu alıp işlicem.
//        kafkaTemplate.send("orderTopic", new OrderCreatedEvent(order.getId()));*/
//    }


}
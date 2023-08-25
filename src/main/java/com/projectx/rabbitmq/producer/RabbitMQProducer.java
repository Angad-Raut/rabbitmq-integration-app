package com.projectx.rabbitmq.producer;

import com.projectx.rabbitmq.entity.Order;
import com.projectx.rabbitmq.entity.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${order.status}")
    private String orderStatus;

    @Value("${order.place.message}")
    private String message;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @PostMapping(value = "/placeOrder")
    public OrderDto placeOrder(@RequestBody Order order) {
        OrderDto orderDto = OrderDto.builder()
                .order(order)
                .orderStatus(orderStatus)
                .message(message)
                .build();
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderDto);
        return orderDto;
    }
}

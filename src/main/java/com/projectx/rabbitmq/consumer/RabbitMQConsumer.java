package com.projectx.rabbitmq.consumer;

import com.projectx.rabbitmq.entity.OrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final String QUEUE_NAME="rabbit_mq_queue";

    @RabbitListener(queues = QUEUE_NAME)
    public void consumeMessage(OrderDto orderDto) {
        System.out.println("consumer is able to consume the messages :"+orderDto);
    }
}

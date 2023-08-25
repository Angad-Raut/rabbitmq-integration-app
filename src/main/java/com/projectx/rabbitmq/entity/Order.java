package com.projectx.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Long orderId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQty;
}

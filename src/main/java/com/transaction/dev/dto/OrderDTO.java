package com.transaction.dev.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderDTO
 */
@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {

    public Long orderId;
    public String orderDate;
    public Double totalAmount;
    // public List<CustomerDTO> customer;
    // public List<OrderItem> orderItems;

    // public OrderDTO(Long orderId, String orderDate, Double totalAmount, Long customer,
    //         Long orderItems) {
    //     this.orderId = orderId;
    //     this.orderDate = orderDate;
    //     this.totalAmount = totalAmount;
    //     this.customer = customer;
    //     this.orderItems = orderItems;
    // }

    
}
package com.spring.springcore.order;

public interface OrderService {
     Order createOrder(Long memberId, String itemName, int itemPrice);
}
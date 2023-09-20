package com.example.financeapp.service;

import com.example.financeapp.dto.OrderDto;
import com.example.financeapp.dto.request.OrderRequest;

import java.util.List;

public interface OrderService {

    OrderDto getOrderByOrderId(Long ordersId);

    void saveOrder (OrderRequest orderRequest);

    void updateOrder (OrderRequest orderRequest);

    List<OrderDto> getAll();

    void deleteById(Long ordersId);

}

package com.example.financeapp.service.impl;

import com.example.financeapp.service.OrderService;
import com.example.financeapp.dto.OrderDto;
import com.example.financeapp.dto.exeption.ResourceNotFoundException;
import com.example.financeapp.dto.request.OrderRequest;
import com.example.financeapp.model.Order;
import com.example.financeapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderDto getOrderByOrderId(Long ordersId) {
        Order order = orderRepository.findById(ordersId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", ordersId));
        return OrderDto.builder()
                .bankTo(order.getBankTo())
                .accountTo(order.getAccountTo())
                .amount(order.getAmount())
                .type(order.getType())
                .build();
    }

    public void saveOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .bankTo(orderRequest.getBankTo())
                .accountTo(orderRequest.getAccountTo())
                .amount(orderRequest.getAmount())
                .type(orderRequest.getType())
                .build();
        orderRepository.save(order);
    }

    public void updateOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .ordersId(orderRequest.getOrdersId())
                .accountId(orderRequest.getAccountId())
                .bankTo(orderRequest.getBankTo())
                .accountTo(orderRequest.getAccountTo())
                .amount(orderRequest.getAmount())
                .type(orderRequest.getType())
                .build();
        orderRepository.save(order);
    }

    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = OrderDto.builder()
                    .bankTo(order.getBankTo())
                    .accountTo(order.getAccountTo())
                    .amount(order.getAmount())
                    .type(order.getType())
                    .build();
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    public void deleteById(Long ordersId) {
        Order order = orderRepository.findById(ordersId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", ordersId));
        orderRepository.deleteById(ordersId);
    }
}

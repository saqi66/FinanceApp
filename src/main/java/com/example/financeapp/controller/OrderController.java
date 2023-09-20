package com.example.financeapp.controller;

import com.example.financeapp.dto.OrderDto;
import com.example.financeapp.dto.request.OrderRequest;
import com.example.financeapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {

    final OrderService orderService;

    @GetMapping(value = "/orderList")
    public List<OrderDto> getOrderInfo() {
        return orderService.getAll();
    }

    @GetMapping(value = "/getOrderById/{id}")
    public OrderDto getOrderById(@PathVariable(value = "id") Long orderId) {
        return orderService.getOrderByOrderId(orderId);
    }

    @PostMapping(value = "/saveOrder")
    public void saveOrder(@RequestBody OrderRequest orderRequest) {
        orderService.saveOrder(orderRequest);
    }

    @PutMapping(value = "/updateOrder")
    public void updateOrder(@RequestBody OrderRequest orderRequest) {
        orderService.updateOrder(orderRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long orderId) {
        orderService.deleteById(orderId);
    }
}

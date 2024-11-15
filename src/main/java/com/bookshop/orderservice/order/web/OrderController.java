package com.bookshop.orderservice.order.web;

import jakarta.validation.Valid;
import com.bookshop.orderservice.order.domain.Order;
import com.bookshop.orderservice.order.domain.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(
            @RequestBody @Valid OrderRequest orderRequest
    ) {
        return orderService.submitOrder(
                orderRequest.isbn(), orderRequest.quantity()
        );
    }
}

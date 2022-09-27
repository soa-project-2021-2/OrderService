package soa.nozama.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.nozama.orderservice.model.Order;
import soa.nozama.orderservice.repository.OrderRepository;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> listAll(){
        return orderRepository.findAll();
    }

    @PostMapping
    public Order save(@RequestBody Order order){
        return orderRepository.save(order);
    }
}

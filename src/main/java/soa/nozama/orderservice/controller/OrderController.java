package soa.nozama.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import soa.nozama.orderservice.model.Order;
import soa.nozama.orderservice.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> listAll(){
        List<Order> orders = new ArrayList<Order>();

        orderRepository.findAll().forEach(orders::add);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> listById(@PathVariable("orderId") int orderId){
        Order order = orderRepository.findById(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> listAllByUserId(@PathVariable("userId") String userId){
        List<Order> orders = orderRepository.findAllByUserId(userId);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){

        Order newOrder = new Order( order.getUserId(), order.getProducts());

        Order _order = orderRepository.save(newOrder);

        String url = "http://localhost:8000";

        RestTemplate restTemplate = new RestTemplate();
        try {
            System.out.println(restTemplate.postForObject(url, _order, Order.class));
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(_order, HttpStatus.CREATED);
    }

    @PatchMapping("/{orderId}/updateStatus")
    public ResponseEntity<Order> updateStatus(@PathVariable("orderId") long orderId, @RequestBody String status){

        Order order = orderRepository.findById(orderId);
        order.setStatus(status);

        Order _order = orderRepository.save(order);

        String url = "http://localhost:8000";

        RestTemplate restTemplate = new RestTemplate();
        try {
            System.out.println(restTemplate.postForObject(url, _order, Order.class));
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(_order, HttpStatus.CREATED);
    }

}

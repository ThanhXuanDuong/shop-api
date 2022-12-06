package de.neuefische.springshopservice.controller;

import de.neuefische.springshopservice.model.Order;
import de.neuefische.springshopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ShopService service;

    @GetMapping
    public Map<Integer, Order> listOrders(){
        return service.listOrders();
    }

    @GetMapping(path="/{id}")
    public Order getOrder(@PathVariable int id){
        return service.getOrder(id);
    }

    @PostMapping(path="/{id}")
    public Map<Integer, Order> addOrder(@PathVariable int id,@RequestBody Order order) throws Exception {
        return service.addOrder(id,order);
    }

    @DeleteMapping(path="/{id}")
    public Map<Integer, Order> deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

    @PutMapping(path="/{id}")
    public Map<Integer, Order> putOrder(@PathVariable int id,@RequestBody Order newOrder) {
        return service.putOrder(id,newOrder);
    }
}
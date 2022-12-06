package de.neuefische.springshopservice.controller;

import de.neuefische.springshopservice.model.Order;
import de.neuefische.springshopservice.model.Product;
import de.neuefische.springshopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ShopService service;

    @GetMapping
    public Map<Integer,Product> listProducts(){
        return service.listProducts();
    }

    @GetMapping(path="/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping
    public Map<Integer, Product> addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @DeleteMapping(path="/{id}")
    public Map<Integer, Product> deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}

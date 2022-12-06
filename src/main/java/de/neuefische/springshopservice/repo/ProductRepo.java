package de.neuefische.springshopservice.repo;

import de.neuefische.springshopservice.model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@Repository
public class ProductRepo {
    private Map<Integer, Product> products = new HashMap<>(Map.of(
            1,new Product(1,"t-shirt"),
            2,new Product(2,"pants"),
            3,new Product(3,"socks")));

    public Map<Integer, Product> add(Product product) {
        products.put(product.getId(), product);
        return products;
    }

    public Map<Integer, Product> list() {
        return products;
    }

    public Map<Integer, Product> delete(int id) {
        products.remove(id);
        return products;
    }
    public Product get(int id) {
        if (products.get(id) != null) {
            return products.get(id);
        } else {
            throw new IndexOutOfBoundsException("Product not found!");
        }
    }
}

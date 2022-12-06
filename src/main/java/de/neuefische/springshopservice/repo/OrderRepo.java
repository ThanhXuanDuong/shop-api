package de.neuefische.springshopservice.repo;

import de.neuefische.springshopservice.model.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@Repository
public class OrderRepo {
    private final Map<Integer, Order> orders;

    public Map<Integer,Order> add(Order order) {
        orders.put(order.getId(), order);
        return orders;
    }

    public Map<Integer,Order> list(){
        return orders;
    }

    public Order get(int id){
        if (orders.get(id)!=null) {
            return orders.get(id);
        } else {
            throw new IndexOutOfBoundsException("Order not found!");
        }
    }

    public Map<Integer,Order> delete(int id){
        orders.remove(id);
        return orders;
    }

    public Map<Integer, Order> put(int id,Order newOrder){
        orders.remove(id);
        orders.put(id,newOrder);
        return orders;
    }

}

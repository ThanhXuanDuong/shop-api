package de.neuefische.springshopservice.service;

import de.neuefische.springshopservice.model.Order;
import de.neuefische.springshopservice.model.Product;
import de.neuefische.springshopservice.repo.OrderRepo;
import de.neuefische.springshopservice.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ShopService {
    private  final ProductRepo productRepo;
    private  final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id){
        return productRepo.get(id);
    }

    public Map<Integer, Product> listProducts(){
        return productRepo.list();
    }

    public Map<Integer, Product> addProduct(Product product){
        return productRepo.add(product);
    }
    public Map<Integer, Product> deleteProduct(int id){
        return productRepo.delete(id);
    }
    public Map<Integer, Order> addOrder(int id,Order newOrder) throws Exception {
        if (!containsNonExistedProduct(newOrder)) {
            return orderRepo.put(id,newOrder);
        }else {
            throw new Exception("Order contains non existed product!");
        }
    }

    public Order getOrder(int id){
        return orderRepo.get(id);
    }

    public Map<Integer, Order> listOrders(){
        return orderRepo.list();
    }

    public Map<Integer, Order> deleteOrder(int id){
        return orderRepo.delete(id);
    }

    public Map<Integer, Order> putOrder(int id,Order newOrder){
        return orderRepo.put(id,newOrder);
    }

    public boolean containsNonExistedProduct(Order newOrder){
        List<Integer> orderedProductIds=newOrder.getProductIds();
        Set<Integer> productRepoIds=productRepo.list().keySet();
        for (Integer orderedProduct: orderedProductIds){
            if (!productRepoIds.contains(orderedProduct)){
                return true;
            }
        }
        return false;

    }


}

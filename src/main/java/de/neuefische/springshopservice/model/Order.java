package de.neuefische.springshopservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private List<Integer> productIds;
}

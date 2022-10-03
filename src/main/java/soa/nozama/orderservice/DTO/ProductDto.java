package soa.nozama.orderservice.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link soa.nozama.orderservice.model.Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final String id;
    private final String name;
    private final double price;
    private final int qty;
}
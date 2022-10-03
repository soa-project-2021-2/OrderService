package soa.nozama.orderservice.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link soa.nozama.orderservice.model.Order} entity
 */
@Data
public class OrderDto implements Serializable {
    private final long id;
    private final String userId;
    private final List<ProductDto> products;
    private final double amount;
    private final String status;
    private final Date createdAt;
}
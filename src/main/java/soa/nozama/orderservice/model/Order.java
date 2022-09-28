package soa.nozama.orderservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userId")
    private String userId;

    @ElementCollection
    private List<Product> products = new ArrayList<>();

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Order(String userId, List<Product> products) {

        double amount = 0;

        for(Product product : products){
            amount += product.getPrice() * product.getQty();
        }

        this.userId = userId;
        this.products = products;
        this.amount = amount;
        this.status = "Created";
        this.createdAt = new Date();
    }
}

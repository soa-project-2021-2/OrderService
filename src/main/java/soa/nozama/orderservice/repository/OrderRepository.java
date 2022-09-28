package soa.nozama.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soa.nozama.orderservice.model.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    Order findById(long id);

    List<Order> findAllByUserId(String userId);

    Optional<Order> findAllByStatus(String status);

    Order save(Order order);
}

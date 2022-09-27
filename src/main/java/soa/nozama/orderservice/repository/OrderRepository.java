package soa.nozama.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soa.nozama.orderservice.model.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    Optional<Order> findById(long id);

    List<Order> findByUserId(int userId);

    List<Order> findByStatus(String status);

    Order save(Order usuario);
}

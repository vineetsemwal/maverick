package org.example.orderms.repository;

import org.example.orderms.entity.CreatedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<CreatedOrder,Long> {
    List<CreatedOrder>findByCustomerId(long customerId);
}

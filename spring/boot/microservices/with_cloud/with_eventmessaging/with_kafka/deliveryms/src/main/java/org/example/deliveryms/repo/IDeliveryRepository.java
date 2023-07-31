package org.example.deliveryms.repo;

import org.example.deliveryms.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery>findDeliveryByOrderId(long orderId);
}

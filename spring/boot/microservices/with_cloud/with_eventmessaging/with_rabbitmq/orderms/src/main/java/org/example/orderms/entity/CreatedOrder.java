package org.example.orderms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "id")
@Data
@Entity
public class CreatedOrder {
    @GeneratedValue
    @Id
    private Long id;
    private Long productId;
    private Long customerId;
    private String customerName;
    private String productName;
    private double productPrice;
    private int units;
    private LocalDateTime createdDateTime;
    private double orderTotal;

}

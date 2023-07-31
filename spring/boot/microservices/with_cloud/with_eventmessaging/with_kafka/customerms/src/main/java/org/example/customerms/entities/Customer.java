package org.example.customerms.entities;

import lombok.*;
import org.example.customerms.dtos.OrderDetails;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Long id;
    private String name;

    private double balance;

    @ElementCollection
    private List<Long> orders;


}

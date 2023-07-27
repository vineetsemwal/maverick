package org.example.customerms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Long id;
    private String name;

    @ElementCollection
    private List<Long>boughtProducts;


}

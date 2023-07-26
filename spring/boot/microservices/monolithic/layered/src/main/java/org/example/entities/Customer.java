package org.example.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @ManyToMany
    private List<Product>boughtProducts;

}

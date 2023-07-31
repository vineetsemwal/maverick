package org.example.productms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@NamedQuery(name="Product.findByNameInAscending",query="from Product where name=:name order by price")
@Entity
public class Product {
    @GeneratedValue
    @Id
    private Long id;
    @NonNull
    @Column(unique = true)
    private String name;
    @NonNull
    private double price;
    private int units;
}

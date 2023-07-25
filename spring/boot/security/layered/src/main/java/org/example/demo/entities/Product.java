package org.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name="Product.findByNameInAscending",query="from Product where name=:name order by price")
@Entity
public class Product {
    @GeneratedValue
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private double price;

    public Product(){}
    public Product(String name, double price){
        this.name=name;
        this.price=price;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

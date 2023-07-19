package org.example.dao;

import org.example.entities.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductDaoImpl implements IProductDao{
    private Map<Long,Product>store=new HashMap<>();

    @Override
    public void save(Product product) {
    store.put(product.getId(),product);
    }

    @Override
    public Optional<Product> findById(long id) {
        Product product=store.get(id);
        if(product==null){
            return Optional.empty();
        }
        return Optional.of(product);

    }
}

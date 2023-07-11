package patterns.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService{
    private Map<Long,Product>store=new HashMap<>();

    @Override
    public List<Product> fetchAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Product findById(long productId) {
        return store.get(productId);
    }

    @Override
    public void add(Product product) {
        store.put(product.getId(),product);
    }


}

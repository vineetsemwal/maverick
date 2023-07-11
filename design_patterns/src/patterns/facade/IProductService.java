package patterns.facade;

import java.util.List;

public interface IProductService {
    List<Product> fetchAll();

    Product findById(long productId);

    void add(Product product);
}

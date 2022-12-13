package pl.training.products;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Long id);
}

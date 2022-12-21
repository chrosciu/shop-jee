package com.chrosciu.shop.products;

import java.util.List;
import java.util.Optional;
import javax.ejb.Remote;

@Remote
public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}

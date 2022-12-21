package com.chrosciu.shop.products;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();

    Product findById(long id);

    List<Product> findAllExceptType(ProductType productType);

    List<Product> findAllCheaperThan(long price);
}

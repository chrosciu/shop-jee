package com.chrosciu.shop.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

@Singleton
public class HashMapProductRepository implements ProductRepository {
    private Map<Long, Product> products = new HashMap<>();
    private long index = 0;

    @Override
    public Product save(Product product) {
        product.setId(++index);
        products.put(index, product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }
}

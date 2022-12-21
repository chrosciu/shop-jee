package com.chrosciu.shop.products;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class JpaProductRepository implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return entityManager
            .createQuery("select p from Product p", Product.class)
            .getResultList();
    }

    @Override
    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAllExceptType(ProductType productType) {
        return entityManager
            .createNamedQuery(Product.FIND_ALL_EXCEPT_TYPE, Product.class)
            .setParameter("productType", productType)
            .getResultList();
    }
}

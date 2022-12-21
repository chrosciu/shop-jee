package com.chrosciu.shop.products;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
            .createNamedQuery(Product.FIND_ALL_EXCEPT_TYPE)
            .setParameter("productType", productType)
            .getResultList();
    }

    @Override
    public List<Product> findAllCheaperThan(long price) {
        return entityManager
            .createNamedQuery(Product.FIND_ALL_CHEAPER_THAN)
            .setParameter("price", price)
            .getResultList();
    }


}

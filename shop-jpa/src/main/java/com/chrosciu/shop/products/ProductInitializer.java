package com.chrosciu.shop.products;

import lombok.extern.jbosslog.JBossLog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;
import java.util.List;

@Singleton
@Startup
@JBossLog
public class ProductInitializer {
    @EJB
    private ProductRepository productRepository;

    private static final Product VIDEO_PRODUCT = Product.builder()
        .name("Spring masterclass")
        .description("Praktyczny kurs Spring framework")
        .type(ProductType.VIDEO)
        .price(BigDecimal.valueOf(1500))
        .build();

    private static final Product BOOK_PRODUCT = Product.builder()
        .name("Spring guide")
        .description("Praktyczne ćwiczenia do samodzielnego wykonania")
        .type(ProductType.BOOK)
        .price(BigDecimal.valueOf(200))
        .build();

    @PostConstruct
    public void init() {
        log.info("Initializing products");
        productRepository.save(VIDEO_PRODUCT);
        productRepository.save(BOOK_PRODUCT);
        log.info("Products initialized!");

        List<Product> productsExceptBooks = productRepository.findAllExceptType(ProductType.BOOK);
        log.info(String.format("productsExceptBooks : %s", productsExceptBooks));
    }
}

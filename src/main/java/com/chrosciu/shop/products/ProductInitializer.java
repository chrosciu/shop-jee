package com.chrosciu.shop.products;


import lombok.extern.jbosslog.JBossLog;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;

@Singleton
@Startup
@JBossLog
public class ProductInitializer {
    private ProductRepository productRepository = new HashMapProductRepository();

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
    }
}

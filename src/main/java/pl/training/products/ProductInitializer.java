package pl.training.products;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ProductInitializer {

    @EJB
    private ProductRepository productRepository;

    private static final Product VIDEO_PRODUCT = Product.builder()
        .name("Spring masterclass")
        .description("Praktyczny kurs Spring framework")
        .type(ProductType.VIDEO)
        .price(PolishMoney.of(1500))
        .build();

    private static final Product BOOK_PRODUCT = Product.builder()
        .name("Spring guide")
        .description("Praktyczne ćwiczenia do samodzielnego wykonania")
        .type(ProductType.BOOK)
        .price(PolishMoney.of(200))
        .build();

    @PostConstruct
    public void postConstruct() {
        productRepository.save(VIDEO_PRODUCT);
        productRepository.save(BOOK_PRODUCT);
    }

}

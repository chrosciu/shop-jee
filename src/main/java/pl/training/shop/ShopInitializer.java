package pl.training.shop;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import pl.training.common.PolishMoney;
import pl.training.orders.Order;
import pl.training.orders.OrderRepository;
import pl.training.products.Product;
import pl.training.products.ProductRepository;
import pl.training.products.ProductType;

@Singleton
@Startup
public class ShopInitializer {
    @EJB
    private ProductRepository productRepository;
    @EJB
    private OrderRepository orderRepository;

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
        Product savedVideo = productRepository.save(VIDEO_PRODUCT);
        Product savedBook = productRepository.save(BOOK_PRODUCT);

        Order order = new Order(List.of(savedVideo, savedBook));
        orderRepository.save(order);
    }
}

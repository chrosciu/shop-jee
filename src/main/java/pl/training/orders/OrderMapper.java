package pl.training.orders;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import pl.training.common.FastMoneyMapper;
import pl.training.products.Product;
import pl.training.products.ProductRepository;

@Mapper(uses = FastMoneyMapper.class)
public abstract class OrderMapper {
    public Order fromInputDto(OrderInputDto orderDto, ProductRepository productRepository) {
        List<Product> products = orderDto.getProductsIds().stream()
            .map(productRepository::findById)
            .collect(Collectors.toList());
        return new Order(products);
    }

    public OrderOutputDto toOutputDto(Order order) {
        List<Long> productsIds = order.getProducts().stream()
            .map(Product::getId)
            .collect(Collectors.toList());
        return new OrderOutputDto(order.getId(), productsIds);
    }
}

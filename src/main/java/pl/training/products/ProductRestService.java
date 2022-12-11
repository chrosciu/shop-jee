package pl.training.products;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.mapstruct.factory.Mappers;

@Path("products")
public class ProductRestService {
    @EJB
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @PostConstruct
    public void postConstruct() {
        productMapper = Mappers.getMapper(ProductMapper.class);
    }

    @GET
    public List<ProductOutputDto> getProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toOutputDto)
            .collect(Collectors.toList());
    }
}

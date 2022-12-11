package pl.training.products;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductOutputDto> getProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toOutputDto)
            .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductOutputDto addProduct(ProductInputDto productInputDto) {
        Product productToAdd = productMapper.fromInputDto(productInputDto);
        Product product = productRepository.save(productToAdd);
        return productMapper.toOutputDto(product);
    }
}

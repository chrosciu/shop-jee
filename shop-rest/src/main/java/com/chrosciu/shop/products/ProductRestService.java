package com.chrosciu.shop.products;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mapstruct.factory.Mappers;

@Path("products")
public class ProductRestService {
    @EJB
    private ProductRepository productRepository;

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductOutputDto> getProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toDto)
            .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductOutputDto getProduct(@PathParam("id") long id) {
        return Optional.ofNullable(productRepository.findById(id))
            .map(productMapper::toDto)
            .orElseThrow(() -> new ProductNotFoundException(id));
    }
}

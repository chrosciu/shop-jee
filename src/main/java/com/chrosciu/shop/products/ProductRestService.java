package com.chrosciu.shop.products;

import org.mapstruct.factory.Mappers;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

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

}

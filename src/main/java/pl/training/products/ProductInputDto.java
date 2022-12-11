package pl.training.products;

import lombok.Data;

@Data
public class ProductInputDto {
    private String name;
    private String description;
    private String price;
    private ProductType type;
}

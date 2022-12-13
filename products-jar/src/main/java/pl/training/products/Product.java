package pl.training.products;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import org.javamoney.moneta.FastMoney;

@Builder
@Data
public class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private FastMoney price;
    private ProductType type;
}
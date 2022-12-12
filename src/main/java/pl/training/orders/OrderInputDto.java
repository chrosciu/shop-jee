package pl.training.orders;

import java.util.List;
import lombok.Data;

@Data
public class OrderInputDto {
    private List<Long> productsIds;
}

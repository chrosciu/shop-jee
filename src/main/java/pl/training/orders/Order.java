package pl.training.orders;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;
import pl.training.common.PolishMoney;
import pl.training.products.Product;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Serializable {
    private Long id;
    @NonNull
    private List<Product> products;

    public FastMoney getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(PolishMoney.zero(), FastMoney::add);
    }
}

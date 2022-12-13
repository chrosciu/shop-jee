package pl.training.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final Long id;
}

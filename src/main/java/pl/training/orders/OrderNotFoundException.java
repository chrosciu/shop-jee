package pl.training.orders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderNotFoundException extends RuntimeException {
    private final Long id;
}
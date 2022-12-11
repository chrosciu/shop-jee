package pl.training.common;

import java.util.Optional;
import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;

@Mapper
public interface FastMoneyMapper {
    default String toPrice(FastMoney price) {
        return Optional.ofNullable(price).map(FastMoney::toString).orElse("");
    }
}

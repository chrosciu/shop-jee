package pl.training.products;

import org.mapstruct.Mapper;
import pl.training.common.FastMoneyMapper;

@Mapper(uses = FastMoneyMapper.class)
public interface ProductMapper {
    ProductOutputDto toOutputDto(Product product);
}
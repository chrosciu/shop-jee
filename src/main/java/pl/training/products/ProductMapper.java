package pl.training.products;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.common.FastMoneyMapper;

@Mapper(uses = FastMoneyMapper.class)
public interface ProductMapper {
    ProductOutputDto toOutputDto(Product product);
    @Mapping(target="id", ignore = true)
    Product fromInputDto(ProductInputDto productDto);
}
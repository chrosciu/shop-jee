package com.chrosciu.shop.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
@NamedQuery(
    name = Product.FIND_ALL_EXCEPT_TYPE,
    query = "select p from Product p where p.type <> :productType"
)
public class Product implements Serializable {
    public static final String FIND_ALL_EXCEPT_TYPE = "Product.findAllExceptType";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductType type;
}

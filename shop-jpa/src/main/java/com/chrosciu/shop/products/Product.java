package com.chrosciu.shop.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
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
@NamedNativeQuery(
    name = Product.FIND_ALL_CHEAPER_THAN,
    query = "select * from products where price < :price",
    resultClass = Product.class
)
public class Product implements Serializable {
    public static final String FIND_ALL_EXCEPT_TYPE = "Product.findAllExceptType";
    public static final String FIND_ALL_CHEAPER_THAN = "Product.findAllCheaperThan";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
}

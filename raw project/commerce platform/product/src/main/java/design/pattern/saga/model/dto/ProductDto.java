package design.pattern.saga.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
public class ProductDto implements Serializable {
    private String name;
    private String description;
    private BigDecimal price;


}

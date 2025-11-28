package design.pattern.model.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private String name;
    private String description;
    private BigDecimal price;


}

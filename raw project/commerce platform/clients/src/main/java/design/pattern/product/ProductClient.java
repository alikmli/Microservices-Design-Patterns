package design.pattern.product;


import design.pattern.dto.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@FeignClient(name = "PRODUCT", path = "api/v1/product")
public interface ProductClient {

    @GetMapping("/find/name/{name}")
    ResponseEntity<ServiceResult<?>> findProductByName(@PathVariable(name = "name") String name);

    @GetMapping("/find/id/{id}")
    ResponseEntity<ServiceResult<?>> findProductById(@PathVariable(name = "id") Long id);

}

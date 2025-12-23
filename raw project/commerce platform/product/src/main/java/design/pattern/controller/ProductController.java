package design.pattern.controller;

import design.pattern.dto.ServiceResult;
import design.pattern.model.dto.ProductDto;
import design.pattern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ServiceResult<?>> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(new ServiceResult<>(productService.save(productDto)));
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<ServiceResult<?>> findProductByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(new ServiceResult<>(productService.findByName(name)));
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<ServiceResult<?>> findProductById(@PathVariable(name = "id") Long id) {
        ProductDto product = productService.findById(id);
        if(Objects.nonNull(product)) {
            return ResponseEntity.ok(new ServiceResult<>(product));
        }
        return ResponseEntity.notFound().build();
    }
}

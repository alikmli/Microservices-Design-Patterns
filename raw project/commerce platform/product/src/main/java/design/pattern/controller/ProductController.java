package design.pattern.controller;

import design.pattern.dto.ServiceResult;
import design.pattern.model.dto.ProductDto;
import design.pattern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<ServiceResult<?>> findProduct(@PathVariable(name = "name") String name) {
        ProductDto product = productService.findByName(name);
        return ResponseEntity.ok(new ServiceResult<>(product));
    }
}

package design.pattern.saga.controller;

import design.pattern.saga.model.dto.ProductDto;
import design.pattern.saga.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
}

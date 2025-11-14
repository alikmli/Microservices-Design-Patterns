package design.pattern.saga.service;

import design.pattern.saga.model.dto.ProductDto;
import design.pattern.saga.model.entity.Product;
import design.pattern.saga.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(ProductDto productDto) {
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }
}

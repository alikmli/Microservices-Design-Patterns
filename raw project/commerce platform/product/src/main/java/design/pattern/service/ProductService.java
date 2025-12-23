package design.pattern.service;

import design.pattern.model.dto.ProductDto;
import design.pattern.model.entity.Product;
import design.pattern.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProductDto save(ProductDto productDto) {
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Product savedProduct = productRepository.save(product);

        productDto.setId(savedProduct.getId());
        return productDto;
    }

    @Transactional
    public List<ProductDto> findByName(String name) {
        List<Product> products=productRepository.findByName(name);
        return products.stream().map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto findById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        return product.map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice())).orElse(null) ;
    }
}

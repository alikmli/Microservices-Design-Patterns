package design.pattern.service;

import design.pattern.dto.ServiceResult;
import design.pattern.model.dto.InventoryDto;
import design.pattern.model.entity.Inventory;
import design.pattern.product.ProductClient;
import design.pattern.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductClient productClient;


    public InventoryService(InventoryRepository inventoryRepository, ProductClient productClient) {
        this.inventoryRepository = inventoryRepository;
        this.productClient = productClient;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void save(InventoryDto inventoryDto) {
        ResponseEntity<ServiceResult<?>> product = productClient.findProductById(inventoryDto.getProductId());
        if (product.getStatusCode().is2xxSuccessful() && Objects.nonNull(product.getBody())) {
            Optional<Inventory> currentItem = inventoryRepository.findByProductId(inventoryDto.getProductId());
            if(currentItem.isPresent()) {
                currentItem.get().setAvailable(currentItem.get().getAvailable() + inventoryDto.getAvailable());
            }else {
                Inventory inventory = new Inventory();
                inventory.setProductId(inventoryDto.getProductId());
                inventory.setAvailable(inventoryDto.getAvailable());
                inventory.setReserved(inventoryDto.getReserved());
                inventoryRepository.save(inventory);
            }
        }
    }


}

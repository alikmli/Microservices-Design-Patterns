package design.pattern.controller;

import design.pattern.dto.ServiceResult;
import design.pattern.model.dto.DiscountDto;
import design.pattern.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/discount")
public class DiscountController {


    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/create")
    public void create(DiscountDto discount) {
        discountService.createDiscount(discount);
    }

    @PostMapping("/find/{code}")
    public ResponseEntity<ServiceResult<?>> findByCode(@PathVariable("code") String code) {
        DiscountDto discount = discountService.findDiscountByCode(code);
        if(Objects.nonNull(discount)) {
            return ResponseEntity.ok(new ServiceResult<>(discount));
        }
        return ResponseEntity.notFound().build();
    }

}

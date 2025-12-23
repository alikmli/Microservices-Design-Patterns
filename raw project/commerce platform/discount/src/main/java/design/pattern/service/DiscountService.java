package design.pattern.service;


import design.pattern.model.dto.DiscountDto;
import design.pattern.model.entity.Discount;
import design.pattern.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;


    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createDiscount(DiscountDto discountDto) {
        Discount discount = new Discount();
        discount.setCode(discountDto.getCode());
        discount.setPercentage(discountDto.getPercentage());
        discount.setExpireTime(discountDto.getExpireTime());

        discountRepository.save(discount);
    }

    @Transactional
    public DiscountDto findDiscountByCode(String code) {
        Optional<Discount> discount = discountRepository.findByCode(code);
        return discount.map(value -> new DiscountDto(value.getCode(), value.getPercentage(), value.getExpireTime())).orElse(null);
    }


 }

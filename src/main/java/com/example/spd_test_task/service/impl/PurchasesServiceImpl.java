package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.ProductDTO;
import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.enums.PaymentType;
import com.example.spd_test_task.mappers.ProductMapper;
import com.example.spd_test_task.mappers.PurchasesMapper;
import com.example.spd_test_task.model.Product;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.model.User;
import com.example.spd_test_task.repository.ProductRepository;
import com.example.spd_test_task.repository.PurchasesRepository;
import com.example.spd_test_task.repository.UserRepository;
import com.example.spd_test_task.service.PurchasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PurchasesServiceImpl implements PurchasesService {

    private final PurchasesRepository purchasesRepository;
    private final PurchasesMapper purchasesMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final  ProductMapper productMapper;

    @Override
    @Transactional
    public PurchasesDTO save(PurchasesDTO purchasesDTO) {

        System.out.println("Initial purchase  "+purchasesDTO);
        User user = userRepository.getById(purchasesDTO.getUser().getId());

        Product product = productRepository.getById(purchasesDTO.getProduct().getId());

        user.setOrdersSum(user.getOrdersSum().add(product.getProductPrice()));
        if (purchasesDTO.getType().equals(PaymentType.CARD)) {
            user.setCardSum(user.getCardSum().add(product.getProductPrice()));
        } else {
            user.setCashSum(user.getCashSum().add(product.getProductPrice()));
        }

        userRepository.save(user);


        Purchases purchases = purchasesMapper.purchasesDtoToPurchases(purchasesDTO);
        purchases.setProduct(product);  // Мапстракт выебывался, пришлось руками засетить
        Purchases save = purchasesRepository.save(purchases);
        System.out.println("last Product " +product);
        System.out.println("last purchase  " + purchasesDTO);

        return purchasesMapper.purchasesToPurchasesDto(save);
    }
}

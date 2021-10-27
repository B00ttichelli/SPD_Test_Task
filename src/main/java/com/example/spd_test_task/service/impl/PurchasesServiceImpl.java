package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.mappers.PurchasesMapper;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.repository.PurchasesRepository;
import com.example.spd_test_task.service.PurchasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchasesServiceImpl implements PurchasesService {

    private final PurchasesRepository purchasesRepository;
    private final PurchasesMapper purchasesMapper;

    @Override
    public PurchasesDTO save(PurchasesDTO purchasesDTO) {

        Purchases save = purchasesRepository.save(purchasesMapper.purchasesDtoToPurchases(purchasesDTO));
        return purchasesMapper.purchasesToPurchasesDto(save);
    }
}

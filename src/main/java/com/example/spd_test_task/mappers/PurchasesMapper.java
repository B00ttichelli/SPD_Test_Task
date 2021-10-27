package com.example.spd_test_task.mappers;

import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.model.Purchases;
import org.mapstruct.Mapper;

@Mapper
public interface PurchasesMapper  {
    PurchasesDTO purchasesToPurchasesDto (Purchases purchases);
    Purchases purchasesDtoToPurchases(PurchasesDTO purchasesDTO);
}

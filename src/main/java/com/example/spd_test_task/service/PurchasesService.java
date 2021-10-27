package com.example.spd_test_task.service;

import com.example.spd_test_task.dto.ProductDTO;
import com.example.spd_test_task.dto.PurchasesDTO;
import org.springframework.stereotype.Service;


public interface PurchasesService {
    PurchasesDTO save (PurchasesDTO purchasesDTO);
}

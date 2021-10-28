package com.example.spd_test_task.mappers;

import com.example.spd_test_task.dto.ProductDTO;
import com.example.spd_test_task.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {


    Product productDTOtoProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);
}

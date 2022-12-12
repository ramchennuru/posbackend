package com.example.POSBackend.service;

import com.example.POSBackend.dao.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductDetailService {
    Optional<ProductEntity> getProductDetails(Long id);

    ProductEntity saveProductDetails(ProductEntity product);

    void deleteAllProducts();
}

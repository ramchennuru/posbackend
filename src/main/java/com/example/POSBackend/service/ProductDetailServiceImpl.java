package com.example.POSBackend.service;

import com.example.POSBackend.dao.ProductDetailsRepository;
import com.example.POSBackend.dao.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<ProductEntity> getProductDetails(Long id) {
        return Optional.ofNullable(productDetailsRepository.findById(id).orElse(null));
    }

    @Transactional
    @Override
    public ProductEntity saveProductDetails(ProductEntity product) {
        ProductEntity productResponse = null;
        try {
            productResponse = productDetailsRepository.save(product);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return productResponse;
    }

    @Override
    public void deleteAllProducts() {
        productDetailsRepository.deleteAll();
    }
}

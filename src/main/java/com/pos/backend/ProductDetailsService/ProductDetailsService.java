package com.pos.backend.ProductDetailsService;

import com.pos.backend.ProductDetailsModel.ProductDetailModel;
import org.springframework.stereotype.Service;
import com.pos.backend.ProductDetailsRepository.ProductDetailsRepo;

@Service
public class ProductDetailsService {
    ProductDetailsRepo productDetailsRepo;
    public ProductDetailModel getProductDetails()
    {
        return productDetailsRepo.getProducts();
    }
}

package com.pos.backend.controller;

import com.pos.backend.ProductDetailsModel.ProductDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pos.backend.ProductDetailsService.ProductDetailsService;

@RestController("/productDetails")
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productDetailsService;

    @GetMapping("/getAll")
    public ProductDetailModel getProductDetails()
    {

        return productDetailsService.getProductDetails();
    }
}

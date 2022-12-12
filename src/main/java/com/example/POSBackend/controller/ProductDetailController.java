package com.example.POSBackend.controller;

import com.example.POSBackend.dao.ProductEntity;
import com.example.POSBackend.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productDetail")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
        return productDetailService.saveProductDetails(productEntity);
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> getProductDetail(@PathVariable Long id) {
        return productDetailService.getProductDetails(id);
    }

    @PutMapping("/deleteAll")
    public void deleteAllProducts() {
        productDetailService.deleteAllProducts();
    }

}

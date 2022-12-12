package com.example.POSBackend.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.POSBackend.PosBackendMain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = PosBackendMain.class)
public class ProductDetailRepositoryIntegrationTest {

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    @Test
    public void testSave() {
        ProductEntity product = new ProductEntity("apple", "apple", new Date(), new Date());
        productDetailsRepository.save(product);

        Optional<ProductEntity> productResponse = productDetailsRepository.findById(product.getId());

        assertThat(productResponse.isPresent()).isTrue();
    }

    @Test
    public void testFindById() {
        ProductEntity product = new ProductEntity("apple", "apple", new Date(), new Date());
        ProductEntity savedProduct = productDetailsRepository.save(product);
        Optional<ProductEntity> productResponse = productDetailsRepository.findById(savedProduct.getId());
        assertEquals(productResponse.get().getId(), savedProduct.getId());

    }


}

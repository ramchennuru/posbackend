package com.example.POSBackend.controller;

import com.example.POSBackend.dao.ProductDetailsRepository;
import com.example.POSBackend.dao.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpringExtension.class)
public class ProductDetailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

//    @Test
//    public void whenValidProductInput_thenCreateProduct() throws Exception {
//        createAndSaveProduct("apple", "fresh apple");
//
//        mockMvc.perform(post("/productDetails/addProduct").contentType(MediaType.APPLICATION_JSON));
//        List<ProductEntity> found = productDetailsRepository.findAll();
//
//        assertThat(found).extracting(ProductEntity::getName).containsOnly("apple");
//    }
//
//    @Test
//    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
//        long productId = createAndSaveProduct("banana", "fresh banana");
//
//        mockMvc.perform(get("/productDetails/{id}", productId).contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(productId));
//    }

    public long createAndSaveProduct(String name, String description) {
        ProductEntity product = new ProductEntity(name, description, new Date(), new Date());
        ProductEntity productResponse = productDetailsRepository.save(product);
        return productResponse.getId();
    }

}

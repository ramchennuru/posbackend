package com.pos.backend.ProductDetailsRepository;

import com.pos.backend.ProductDetailsModel.ProductDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetailModel,Long> {

    @Query("select * from products")
    public ProductDetailModel getProducts();

}

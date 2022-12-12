package com.pos.backend.ProductDetailsModel;

import com.pos.backend.ProductDetailsEnum.Currency;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetailModel {
    private long id;
    private long price;
    private Currency currency;
    private String name;
    private String description;
    private Date createDate;
    private int discountRate;


}

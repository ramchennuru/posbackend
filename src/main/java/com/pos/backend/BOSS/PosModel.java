package com.pos.backend.BOSS;

import com.pos.backend.ProductDetailsEnum.Currency;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PosModel {
    @Id
    private long id;
    private long price;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    private String name;
    private String description;
    private Date createDate;
//    @OneToMany(targetEntity = PriceModel.class,cascade = CascadeType.ALL)
//    private List<PriceModel> priceTable;


}

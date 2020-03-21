package hu.kissr.cafeteria.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "purchase_has_product")
public class PurchaseHasProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "purchase_price_total")
    private Integer purchasePriceTotal;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "purchase_id")
    private Long purchaseId;


}

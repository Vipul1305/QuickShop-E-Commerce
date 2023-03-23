package com.ecommerce.QuickShop.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
 // don't create class with name order as it is a reserve keyword in sql which will create conflict
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @CreationTimestamp
    private Date orderDate;

    private int deliveryCharge;

    private int totalCost;

    private String cardUsedForPayment;

    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;
}

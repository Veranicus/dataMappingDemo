package com.example.data.mapping.demo.data.entity;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String recipientName;
    private BigDecimal price;

    //You'll probably need a constructor like this so CriteriaBuilder can create
    public RecipientAndPrice(String recipientName, BigDecimal price) {
        this.recipientName = recipientName;
        this.price = price;
    }
    /* getters and setters */
}
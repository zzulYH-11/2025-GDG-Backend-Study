package com.example.shop.product.dto;

//productId, price

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String productId;
    private String price;

    public ProductCreateRequest(String productId, String price) {
        this.productId = productId;
        this.price = price;
    }
}

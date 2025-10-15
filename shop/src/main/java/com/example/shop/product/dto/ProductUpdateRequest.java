package com.example.shop.product.dto;

//productId, price

import lombok.Getter;

@Getter
public class ProductUpdateRequest {

    private String productId;
    private String price;

    public ProductUpdateRequest(String productId, String price) {
        this.productId = productId;
        this.price = price;
    }
}

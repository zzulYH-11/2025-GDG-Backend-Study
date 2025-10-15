package com.example.shop.product;

import java.net.URI;
import java.util.List;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) {
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/products/" + productID)).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        // Service 계층에서 상품 목록을 가져온다.
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductUpdateRequest request) {
        productService.updateProduct(productId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }


}

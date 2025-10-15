package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //@Transactional
    public Long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findByProductId(request.getProductId());
        if (existingProduct != null) {
            throw new RuntimeException("이미 존재하는 상품 아이디입니다 : " + request.getProductId());
        }

        Product product = new Product(
                request.getProductId(),
                request.getPrice()
        );

        productRepository.save(product);

        return product.getId();
    }

    //@Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId);

        if(product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    //@Transactional
    public void updateProduct(Long productId, ProductUpdateRequest request) {
        Product product = productRepository.findById(productId);

        if(product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        //상품 정보 수정 (도메인 객체의 메서드 사용)
        product.updateInfo(request.getProductId(), request.getPrice());
    }

    //@Transactional
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId);

        if(product == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        //Repository를 통해 삭제
        productRepository.deleteById(productId);
    }
}

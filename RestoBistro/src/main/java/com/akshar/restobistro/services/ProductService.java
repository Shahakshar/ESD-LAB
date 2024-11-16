package com.akshar.restobistro.services;

import com.akshar.restobistro.dto.ProductPriceDto;
import com.akshar.restobistro.models.Product;
import com.akshar.restobistro.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(ProductPriceDto productPriceDto) {
        List<Product> products = productRepository.findAllProducts(productPriceDto.getP1(), productPriceDto.getP2());
        return products.isEmpty() ? null : products;
    }
}

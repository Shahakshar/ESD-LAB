package com.akshar.restobistro.controller;

import com.akshar.restobistro.dto.ProductPriceDto;
import com.akshar.restobistro.models.Product;
import com.akshar.restobistro.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody @Valid Product product) {
        String msg = productService.addProduct(product);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/")
    public ResponseEntity<List<Product>> getProducts(@RequestBody ProductPriceDto productPriceDto) {
        List<Product> products = productService.getProducts(productPriceDto);
        if (products == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

}

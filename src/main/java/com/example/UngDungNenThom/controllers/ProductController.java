package com.example.UngDungNenThom.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.UngDungNenThom.entity.Product;
import com.example.UngDungNenThom.services.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    @GetMapping("/best-sellers")
    public ResponseEntity<List<Product>> getTopBestSellers() {
        return ResponseEntity.ok(productService.getTopBestSellers());
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Product>> getRecentProducts() {
        return ResponseEntity.ok(productService.getRecentProducts());
    }
} 
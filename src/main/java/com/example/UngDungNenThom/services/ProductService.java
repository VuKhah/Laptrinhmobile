package com.example.UngDungNenThom.services;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.UngDungNenThom.entity.Product;
import com.example.UngDungNenThom.repository.IProductRepository;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
    }

    // Lấy top 10 sản phẩm bán chạy nhất
    public List<Product> getTopBestSellers() {
        return productRepository.findTopBestSellers(PageRequest.of(0, 10));
    }

    // Lấy sản phẩm được tạo trong 7 ngày gần đây
    public List<Product> getRecentProducts() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        return productRepository.findRecentProducts(sevenDaysAgo, PageRequest.of(0, 10));
    }
}
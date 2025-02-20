package com.example.UngDungNenThom.repository;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.UngDungNenThom.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    
    // Lấy top 10 sản phẩm bán chạy nhất
    @Query("SELECT p FROM Product p ORDER BY p.soldQuantity DESC")
    List<Product> findTopBestSellers(Pageable pageable);
    
    // Lấy sản phẩm được tạo trong 7 ngày gần đây
    @Query("SELECT p FROM Product p WHERE p.createdDate >= :startDate")
    List<Product> findRecentProducts(LocalDateTime startDate, Pageable pageable);
} 
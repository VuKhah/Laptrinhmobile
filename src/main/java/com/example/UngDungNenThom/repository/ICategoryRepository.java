package com.example.UngDungNenThom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UngDungNenThom.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    // Các phương thức tùy chỉnh có thể được thêm vào đây nếu cần
} 
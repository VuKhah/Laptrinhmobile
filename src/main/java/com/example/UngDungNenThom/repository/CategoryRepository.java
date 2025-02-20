package com.example.UngDungNenThom.repository;



import java.util.List;

import com.example.UngDungNenThom.entity.Category;

public interface CategoryRepository {
    /**
     * Lấy tất cả danh mục từ cơ sở dữ liệu.
     *
     * @return Danh sách tất cả các danh mục.
     */
    List<Category> findAllCategories();
}
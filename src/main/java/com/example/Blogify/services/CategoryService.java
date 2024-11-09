package com.example.Blogify.services;

import com.example.Blogify.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

    List<CategoryDto> getAllCategories();

    void deleteCategory(Long categoryId);

}

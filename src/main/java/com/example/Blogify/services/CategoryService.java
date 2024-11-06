package com.example.Blogify.services;

import com.example.Blogify.entities.Category;
import com.example.Blogify.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

    CategoryDto getCategory(Long categoryId);

    void deleteCategory(Long categoryId);

}

package com.example.Blogify.services;

import com.example.Blogify.entities.Category;
import com.example.Blogify.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    void deleteCategory(Integer categoryId);

    List<CategoryDto> getAllCategory();
}

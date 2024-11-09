package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.Category;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.CategoryDto;
import com.example.Blogify.repositories.CategoryRepo;
import com.example.Blogify.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = modelMapper.map(categoryDto, Category.class);
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Transactional
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        if (category.getCategoryName().equals(categoryDto.getCategoryName())) {
            return categoryDto;
        } else {
            category.setCategoryName(categoryDto.getCategoryName());
            return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
        }

    }

    @Override
    public List<CategoryDto> getAllCategories() {
       List<Category> categories = categoryRepo.findAll();
      return categories.stream().map((category -> modelMapper.map(category, CategoryDto.class))).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepo.delete(category);
    }


}
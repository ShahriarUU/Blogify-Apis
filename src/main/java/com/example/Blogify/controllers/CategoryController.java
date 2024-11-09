package com.example.Blogify.controllers;

import com.example.Blogify.payloads.CategoryDto;
import com.example.Blogify.services.CategoryService;
import com.example.Blogify.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto category)
    {
        CategoryDto createPostCategory = categoryService.createCategory(category);
       return new ResponseEntity<>(createPostCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category,@PathVariable Long categoryId)
    {
        CategoryDto updatePostCategory=categoryService.updateCategory(category,categoryId);
        return new ResponseEntity<>(updatePostCategory,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
     List<CategoryDto> categories= categoryService.getAllCategories();
     return new ResponseEntity<List<CategoryDto>>(categories,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Blog Category delete successfully",true),HttpStatus.OK);
    }

}

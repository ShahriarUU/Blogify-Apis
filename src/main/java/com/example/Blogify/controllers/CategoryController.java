package com.example.Blogify.controllers;

import com.example.Blogify.payloads.CategoryDto;
import com.example.Blogify.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category,@PathVariable Integer categoryId)
    {
        CategoryDto updatePostCategory=categoryService.updateCategory(category,categoryId);
        return new ResponseEntity<>(updatePostCategory,HttpStatus.OK);
    }


}

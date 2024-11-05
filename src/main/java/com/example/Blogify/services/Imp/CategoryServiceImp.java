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

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category=modelMapper.map(categoryDto,Category.class);
       return modelMapper.map(categoryRepo.save(category),CategoryDto.class);
    }

    @Transactional
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

       Category  category= categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));

       if(category.getCategoryName().equals(categoryDto.getCategoryName()))
        {
            return categoryDto;
        }
       else
       {
            category.setCategoryName(categoryDto.getCategoryName());
           return modelMapper.map(categoryRepo.save(category),CategoryDto.class);
       }

    }


    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category= categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category= categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
        categoryRepo.delete(category);

    }

    @Override
    public List<CategoryDto> getAllCategory() {

//       List<Category> categories=categoryRepo.findAll();
//
//       categories.stream().map(this::)
return List.of();
    }

//    private CategoryDto categoryToDto(Category category)
//    {
//        CategoryDto categoryDto=modelMapper.map(category,CategoryDto.class);
//        if(category.getBlogPosts()!=null)
//        {
//            categoryDto.getBlogPosts(modelMapper.map())
//        }
//    }
}

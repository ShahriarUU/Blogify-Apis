package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto extends Audit {

    @NotEmpty(message = "blog category must be mandatory")
    private String categoryName;
    private List<BlogPostDto> blogPosts;
}

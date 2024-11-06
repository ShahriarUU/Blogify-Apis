package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.example.Blogify.payloads.ResponseDto.BlogPostCategoryDto;
import com.example.Blogify.payloads.ResponseDto.BlogPostCommentDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class BlogPostDto extends Audit {

    @NotEmpty(message = "blog title must be mandatory")
    private String title;

    private String image;

    @NotEmpty(message = "blog Content must be mandatory")
    private String content;

    private BlogPostCategoryDto category;

    private ProfileDto profile;

    private BlogPostCommentDto comment;

}

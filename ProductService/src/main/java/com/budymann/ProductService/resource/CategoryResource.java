package com.budymann.ProductService.resource;

import com.budymann.ProductService.domain.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryResource {

    @GetMapping("/category/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId){
        return new CategoryDto();
    }

}

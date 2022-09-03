package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.dataaccess.CategoryDao;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryDto getCategory(Long categoryId){
        return categoryMapper.map(categoryDao.getById(categoryId));
    }
}

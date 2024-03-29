package com.budymann.ProductService.resource;


import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductAttributeDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.dto.RelatedProductDto;
import com.budymann.ProductService.domain.service.ProductService;
import com.budymann.ProductServiceModel.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductResource {
    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable Long productId){
        return productService.getProductDto(productId);
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return productService.getProductDtos();
    }

    @GetMapping("product/prototype")
    public ResponseEntity<ProductResponse> saveProduct(){
        var product = productService.getProductDto(1l);
        Set<RelatedProductDto> relatedProductDtoSet = new HashSet<>();
        relatedProductDtoSet.add(RelatedProductDto.builder().id(2l).build());
        relatedProductDtoSet.add(RelatedProductDto.builder().id(3l).build());
        product.setRelatedProductDto(relatedProductDtoSet);

        Set<ProductAttributeDto> productAttributeDtoSet = new HashSet<>();

        productAttributeDtoSet.add(ProductAttributeDto.builder()
            .id(1l)
            .name("CPU")
            .value("50 ghz")
                .build());

        product.setProductAttributes(productAttributeDtoSet);
        var productDto = productService.saveProduct(product);

        var productResponse = new ProductResponse();
        modelMapper.map(productDto, productResponse);

        return ResponseEntity.ok(productResponse);
    }

}

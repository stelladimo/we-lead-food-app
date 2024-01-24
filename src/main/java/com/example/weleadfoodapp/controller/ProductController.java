package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.mapper.BaseMapper;
import com.example.weleadfoodapp.mapper.ProductMapper;
import com.example.weleadfoodapp.model.Product;
import com.example.weleadfoodapp.service.BaseService;
import com.example.weleadfoodapp.service.ProductService;
import com.example.weleadfoodapp.transfer.ApiResponse;
import com.example.weleadfoodapp.transfer.resource.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController extends BaseController<Product, ProductResource> {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    protected BaseService<Product, Long> getBaseService() {
        return productService;
    }

    @Override
    protected BaseMapper<Product, ProductResource> getMapper() {
        return productMapper;
    }

    @PostMapping(params = "categoryId")
    public ResponseEntity<ApiResponse<ProductResource>> create(@RequestBody final ProductResource productResource,
                                                               @RequestParam Long categoryId) {
        var product = productMapper.toDomain(productResource);
        return new ResponseEntity<>(
                ApiResponse.<ProductResource>builder()
                        .data(getMapper().toResource(productService.create(product, categoryId)))
                        .build(),
                getNoCacheHeaders(),
                HttpStatus.CREATED
        );
    }

    @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<ProductResource>> findBySerial(@RequestParam String serial) {
        final ProductResource productResource = getMapper().toResource(productService.findBySerial(serial));
        return ResponseEntity.ok(ApiResponse.<ProductResource>builder().data(productResource).build());
    }
}

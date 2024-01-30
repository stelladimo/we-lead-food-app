package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.mapper.BaseMapper;
import com.example.weleadfoodapp.mapper.StoreCategoryMapper;
import com.example.weleadfoodapp.model.StoreCategory;
import com.example.weleadfoodapp.service.BaseService;
import com.example.weleadfoodapp.service.StoreCategoryService;
import com.example.weleadfoodapp.transfer.ApiResponse;
import com.example.weleadfoodapp.transfer.resource.StoreCategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storecategories")
@RequiredArgsConstructor
public class StoreCategoryController extends BaseController<StoreCategory, StoreCategoryResource> {
    private final StoreCategoryService storecategoryService;
    private final StoreCategoryMapper storecategoryMapper;

    @Override
    protected BaseService<StoreCategory, Long> getBaseService() {
        return storecategoryService;
    }

    @Override
    protected BaseMapper<StoreCategory, StoreCategoryResource> getMapper() {
        return storecategoryMapper;
    }

    @GetMapping(params = {"description"})
    public ResponseEntity<ApiResponse<StoreCategoryResource>> findByDescription(@RequestParam final String description) {
        return ResponseEntity.ok(ApiResponse.<StoreCategoryResource>builder()
                .data(getMapper().toResource(storecategoryService.findByDescription(description)))
                .build());
    }
}

package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.mapper.BaseMapper;
import com.example.weleadfoodapp.mapper.StoreMapper;
import com.example.weleadfoodapp.model.Store;
import com.example.weleadfoodapp.service.BaseService;
import com.example.weleadfoodapp.service.StoreService;
import com.example.weleadfoodapp.transfer.ApiResponse;
import com.example.weleadfoodapp.transfer.resource.StoreResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stores")
@RequiredArgsConstructor
public class StoreController extends BaseController<Store, StoreResource> {
    private final StoreService storeService;
    private final StoreMapper storeMapper;

    @Override
    protected BaseService<Store, Long> getBaseService() {
        return storeService;
    }

    @Override
    protected BaseMapper<Store, StoreResource> getMapper() {
        return storeMapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StoreResource>> create(@RequestBody final StoreResource storeResource) {
        var store = storeMapper.toDomain(storeResource);
        return new ResponseEntity<>(
                ApiResponse.<StoreResource>builder()
                        .data(getMapper().toResource(storeService.create(store)))
                        .build(),
                getNoCacheHeaders(),
                HttpStatus.CREATED
        );
    }

    @GetMapping(params = "name")
    public ResponseEntity<ApiResponse<StoreResource>> findByName(@RequestParam String name) {

        final StoreResource storeResource = getMapper().toResource(storeService.findByName(name));
        return ResponseEntity.ok(ApiResponse.<StoreResource>builder().data(storeResource).build());
    }
}

package org.example.orderms.util;

import org.example.orderms.dto.ProductDetailsDTO;
import org.example.orderms.dto.ReduceProductUnitsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("productms")
public interface IProductApiUse {

    @PutMapping("/products/quantity/reduce")
    ProductDetailsDTO reduceProductRequest(ReduceProductUnitsRequest request);

}

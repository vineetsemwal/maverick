package org.example.customerms.util;

import org.example.customerms.dtos.ProductDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@FeignClient("productms")
public interface IProductFetcher {

    @PostMapping("/products/by/ids")
    List<ProductDetailsDTO>fetchProductsByIDs(Collection<Long>ids);
}

package org.example.productms.service;

import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.dtos.ReduceUnitsRequest;
import org.example.productms.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Validated
public interface IProductService {
    ProductDetails add(@Valid AddProductDto requestDto);

    ProductDetails findProductDetailsById(@Min(0) long id) throws ProductNotFoundException;

    List<ProductDetails>findByIdIn(@NotEmpty Collection<Long>ids);

    ProductDetails reduceQuantity(@Valid ReduceUnitsRequest request)throws ProductNotFoundException;
}

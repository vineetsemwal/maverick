package org.example.productms.controllers;

import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.dtos.ReduceUnitsRequest;
import org.example.productms.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RequestMapping("/products")
@RestController
public class ProductController {

    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDetails> fetchProductById(@PathVariable @Min(1) long id) throws Exception {
        ResponseEntity<ProductDetails> responseEntity = new ResponseEntity<>(service.findProductDetailsById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/by/ids")
    public ResponseEntity<List<ProductDetails>> fetchProductsById(@RequestBody List<Long> ids) {
        List<ProductDetails> desired = service.findByIdIn(ids);
        ResponseEntity<List<ProductDetails>> responseEntity = new ResponseEntity<>(desired, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<ProductDetails> add(@RequestBody @Valid AddProductDto requestData) {
        ProductDetails desired = service.add(requestData);
        ResponseEntity<ProductDetails> responseEntity = new ResponseEntity<>(desired, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/quantity/reduce")
    public ResponseEntity<ProductDetails>reduceProductsUnit(@RequestBody @Valid ReduceUnitsRequest request)
    throws Exception{
        ProductDetails updated=service.reduceQuantity(request);
        ResponseEntity<ProductDetails> responseEntity = new ResponseEntity<>(updated, HttpStatus.OK);
        return responseEntity;
    }

}

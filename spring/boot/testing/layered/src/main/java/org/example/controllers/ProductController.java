package org.example.controllers;

import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RequestMapping("/products")
@RestController
public class ProductController {

    private IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDetails> fetchProductById(@PathVariable @Min(2) long id)throws Exception{
        ResponseEntity<ProductDetails>responseEntity=new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<ProductDetails>add(@RequestBody @Valid AddProductDto requestData){
        ProductDetails desired=service.add(requestData);
        ResponseEntity<ProductDetails>responseEntity=new ResponseEntity<>(desired,HttpStatus.OK);
        return responseEntity;
    }

}

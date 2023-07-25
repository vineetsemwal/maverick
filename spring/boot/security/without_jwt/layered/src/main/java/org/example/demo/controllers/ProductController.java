package org.example.demo.controllers;

import org.example.demo.dtos.AddProductDto;
import org.example.demo.dtos.ProductDetails;
import org.example.demo.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
public class ProductController {

    private IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }


    @GetMapping( "/c/products/{id}")
    public ResponseEntity<ProductDetails> fetchProductById(@PathVariable @Min(1) long id)throws Exception{
        ResponseEntity<ProductDetails>responseEntity=new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping("/a/products")
    public ResponseEntity<ProductDetails>add(@RequestBody @Valid AddProductDto requestData){
        ProductDetails desired=service.add(requestData);
        ResponseEntity<ProductDetails>responseEntity=new ResponseEntity<>(desired,HttpStatus.OK);
        return responseEntity;
    }

}

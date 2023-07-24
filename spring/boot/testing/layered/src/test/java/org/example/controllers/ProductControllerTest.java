package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.exceptions.ProductNotFoundException;
import org.example.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    IProductService service;


    /**
     * scenario: product found
     *
     * @throws Exception
     */
    @Test
    public void findById_1() throws Exception {
        long id = 1;
        String uri = "/products/" + id;
        ProductDetails bodyObj = new ProductDetails(id, "samsung", 2000);
        when(service.findById(id)).thenReturn(bodyObj);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bodyObj);
        mvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

    }

    /**
     * scenario: product NOT found
     *
     * @throws Exception
     */
    @Test
    public void findById_2() throws Exception {
        long id = 1;
        String uri = "/products/" + id;
        String msg = "product not found";
        doThrow(new ProductNotFoundException(msg)).when(service).findById(id);
        mvc.perform(get(uri))
                .andExpect(status().isNotFound())
                .andExpect(content().string(msg));

    }

    @Test
    public void add_1()throws Exception{
        AddProductDto requestData=new AddProductDto("moto",14000);
        ObjectMapper mapper = new ObjectMapper();
        String requestJson=mapper.writeValueAsString(requestData);
        ProductDetails responseObj=new ProductDetails(1l,"moto",14000);
        String responseJson=mapper.writeValueAsString(responseObj);
        String uri = "/products";
        when(service.add(requestData)).thenReturn(responseObj);
        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
              .andExpect(content().json(responseJson));
    }

}
package org.example.service;

import org.example.dao.IProductDao;
import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.example.util.ProductUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    IProductDao dao;
    @Mock
    ProductUtil util;

    @InjectMocks
    @Spy
    ProductServiceImpl service;

    @Test
    void add() {
        AddProductDto dto = mock(AddProductDto.class);
        Product product = mock(Product.class);
        Product saved = mock(Product.class);
        ProductDetails desired=mock(ProductDetails.class);
        when(util.convertToProduct(dto)).thenReturn(product);
        when(dao.save(product)).thenReturn(saved);
        when(util.convertToProductDetails(saved)).thenReturn(desired);
        ProductDetails result=service.add(dto);
        assertEquals(desired,result);
        verify(dao).save(product);
    }
}
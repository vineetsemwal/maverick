package org.example.service;

import org.example.dao.IProductDao;
import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;
import org.example.util.ProductUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplUnitTest {

    @Mock
    IProductDao repository;
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
        when(repository.save(product)).thenReturn(saved);
        when(util.convertToProductDetails(saved)).thenReturn(desired);
        ProductDetails result=service.add(dto);
        assertEquals(desired,result);
        verify(repository).save(product);
    }

    @Test
    public void findById_ProductFound()throws Exception{
        long id=10;
        Product product=mock(Product.class);
        ProductDetails desired=mock(ProductDetails.class);
        Optional<Product>optional=Optional.of(product);
        when(repository.findById(id)).thenReturn(optional);
        when(util.convertToProductDetails(product)).thenReturn(desired);
        ProductDetails result=service.findById(id);
        verify(repository).findById(id);

    }
    @Test
    public  void findId_ProductNOTFound(){
        long id=10;
        when(repository.findById(id)).thenReturn(Optional.empty());
        Executable executable=()->{
            service.findById(id);
        };
        assertThrows(ProductNotFoundException.class,executable);
        verify(repository).findById(id);
    }

}
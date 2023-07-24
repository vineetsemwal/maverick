package org.example.service;

import org.example.dao.IProductDao;
import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceImplIntegrationTest {

    @Autowired
    ProductServiceImpl service;

    @Autowired
    IProductDao productRepo;


    @Test
    public void testAdd_Success() {
        AddProductDto dto = new AddProductDto("samsung", 20000);
        ProductDetails result = service.add(dto);
        System.out.println("result=" + result);
        List<Product> list = service.findAll();
        assertEquals(1, list.size());
        Product stored=list.get(0);
        assertEquals("samsung",stored.getName());
        assertEquals(Double.valueOf(stored.getPrice()),stored.getPrice());
        assertTrue(stored.getId()!=null);
    }


    @Test
    public void add_Failure() {
        AddProductDto dto = new AddProductDto("samsung", -1);
        Executable executable=()->service.add(dto);
        assertThrows(ConstraintViolationException.class,executable);
    }

    /**
     * scenario: find by id when product exists in store
     * precondition :product exists in store
     *
     * @throws Exception
     */
    @Test
    public void findById_1() throws Exception{
        Product product=new Product("samsung",30000);
        product=productRepo.save(product);
        ProductDetails result=service.findById(product.getId());
        assertEquals("samsung",result.getName());
        assertEquals(Double.valueOf(30000),product.getPrice());
    }

    /**
     * scenario: find by id when product does not exist in store
     * precondition : store doesn't have product
     *
     * @throws Exception
     */
    @Test
    public void findById_2() throws Exception{
       Executable executable=()->service.findById(10);
       assertThrows(ProductNotFoundException.class,executable);
    }



}

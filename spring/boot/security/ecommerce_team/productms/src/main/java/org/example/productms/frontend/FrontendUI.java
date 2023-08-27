package org.example.productms.frontend;

import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.exceptions.ProductNotFoundException;
import org.example.productms.service.IProductService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FrontendUI {
    private IProductService service;
    public FrontendUI(IProductService service){
        this.service=service;
    }

    @PostConstruct
    public void render(){
        try {
            AddProductDto addSamsung=new AddProductDto("samsung", 20000,10);
            ProductDetails samsung = service.add(addSamsung);
            long samsungId = samsung.getId();
            System.out.println("samsung added=" + samsung);
            AddProductDto addMoto=new AddProductDto("moto",15000,20);
            ProductDetails moto = service.add(addMoto);
            System.out.println("moto added=" + moto);
            ProductDetails found = service.findProductDetailsById(samsungId);
            System.out.println("found=" + found);
        }catch (ProductNotFoundException e){
            e.printStackTrace();
        }
    }
}

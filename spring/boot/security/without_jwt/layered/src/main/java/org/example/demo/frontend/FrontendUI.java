package org.example.demo.frontend;

import org.example.demo.dtos.AddProductDto;
import org.example.demo.dtos.ProductDetails;
import org.example.demo.exceptions.ProductNotFoundException;
import org.example.demo.service.IProductService;
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
            AddProductDto addSamsung=new AddProductDto("samsung", 20000);
            ProductDetails samsung = service.add(addSamsung);
            long samsungId = samsung.getId();
            System.out.println("samsung added=" + samsung);
            AddProductDto addMoto=new AddProductDto("moto",15000);
            ProductDetails moto = service.add(addMoto);
            System.out.println("moto added=" + moto);
            ProductDetails found = service.findById(samsungId);
            System.out.println("found=" + found);
        }catch (ProductNotFoundException e){
            e.printStackTrace();
        }
    }
}

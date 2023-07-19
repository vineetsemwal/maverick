package org.example.frontend;

import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;
import org.example.service.IProductService;
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
            Product samsung = service.add("samsung", 2000);
            long samsungId = samsung.getId();
            System.out.println("samsung added=" + samsung);
            Product moto = service.add("moto", 15000);
            System.out.println("moto added=" + moto);
            Product found = service.findById(samsungId);
            System.out.println("found=" + found);
        }catch (ProductNotFoundException e){
            e.printStackTrace();
        }
    }
}

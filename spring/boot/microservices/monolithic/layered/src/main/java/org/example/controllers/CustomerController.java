package org.example.controllers;

import org.example.dtos.AddCustomerRequest;
import org.example.dtos.BuyRequest;
import org.example.dtos.CustomerDetails;
import org.example.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private ICustomerService service;
    public CustomerController(ICustomerService service){
        this.service=service;
    }

    @PostMapping
    public CustomerDetails register(@RequestBody AddCustomerRequest request){
        return service.register(request);
    }

    @GetMapping("/by/id/{id}")
    public CustomerDetails findById(@PathVariable long id)throws Exception{
        return service.findCustomerDetailsById(id);
    }

    @PutMapping("/buy")
    public CustomerDetails buy(@RequestBody BuyRequest request)throws Exception{
        return service.buy(request);
    }

}

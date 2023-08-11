import { TestBed } from '@angular/core/testing';

import { ProductService } from './product.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Product } from './product';

describe('ProductService', () => {
  let service: ProductService;
  let client:MockHttpClient;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule],
      providers:[{provide:HttpClient, useClass:MockHttpClient}]
    });
    client=TestBed.inject(MockHttpClient);
    service = TestBed.inject(ProductService);

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it("products fected successfully",()=>{
   const observable:Observable<Product[]>= service.getProducts();
   observable.subscribe({
    next: (result:Product[])=>{
        console.log("custom verifying result");
      expect(result[0]).toEqual(products[0]);
      expect(result[1]).toEqual(products[1])

    }
  });
  })

  it("addProduct- product created successfully",()=>{
    const requestData={name:"lg",price:67000};
    const observable:Observable<Product> =service.addProduct(requestData);
    observable.subscribe({
      next:(product:Product)=>{
        expect(product).toEqual(createdProduct);
      }
    })
  })

});
const products:Product[]=[
  new Product(1,"samsung",200000),
  new Product(2,"moto",300000)

]
const createdProduct=new Product(4,"iphone",900000);

@Injectable({providedIn:"root"})
class MockHttpClient{

    get(url:string):Observable<Product[]>{

        const resultObs:Observable<Product[]> = of(products);
        return resultObs;
    }
    post(url:string,requestData:any){
   const restObs:Observable<Product>=of(createdProduct);
   return restObs;
    }
}

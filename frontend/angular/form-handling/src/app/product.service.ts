import { Injectable } from '@angular/core';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
products:Product[]=[new Product("samsung",20000),
new Product("moto",15000),
new Product("iphone",90000)
]

getProduct(name:string):Product{
let desired:Product[]=this.products.filter(product=>product.name==name);
if(desired["length"]>0){
  console.log("found",desired);
  return desired[0];
}
throw new Error("product not found");
}




}

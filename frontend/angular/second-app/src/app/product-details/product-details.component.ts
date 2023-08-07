import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'small-product',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent  {
constructor(private service:ProductService){
}

getProduct(name:string):Product{
return this.service.getProduct(name);
}


}

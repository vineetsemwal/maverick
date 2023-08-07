import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'big-product',
  templateUrl: './big-product-details.component.html',
  styleUrls: ['./big-product-details.component.css']
})
export class BigProductDetailsComponent  {
  constructor(private service:ProductService){
  }

  getProduct(name:string):Product{
  return this.service.getProduct(name);
  }


}

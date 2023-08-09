import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent  {

  products:Product[]=[];
  errMsg:string|undefined;
  constructor(private service:ProductService) {
  const observable:Observable<Product[]>= service.getProducts();
  const observer={
    next: (result:Product[])=>{
      this.products=result;
    },
    error:(err:Error)=>{
    this.errMsg=err.message;
    }
  }
  observable.subscribe(observer);
}


}

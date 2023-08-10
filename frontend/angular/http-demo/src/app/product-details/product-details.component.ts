import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent  {
  productId:string|undefined|null;

  constructor(private route:ActivatedRoute, private service:ProductService) {
   const observable:Observable<ParamMap> =route.paramMap;
   const observer={
    next: (result:ParamMap)=>{
     const productIdFetched:|null= result.get("productId");
      this.productName=productNameFetched;
    }};
   observable.subscribe(observer);
  }


}

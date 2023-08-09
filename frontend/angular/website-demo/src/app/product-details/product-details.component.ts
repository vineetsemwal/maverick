import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent  {

  productName:string|undefined|null;

  constructor(private route:ActivatedRoute) {
   const observable:Observable<ParamMap> =route.paramMap;
   const observer={
    next: (result:ParamMap)=>{
     const productNameFetched:string|null= result.get("productName");
      this.productName=productNameFetched;
    }};
   observable.subscribe(observer);
  }



}

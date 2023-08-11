import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../product';

@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  productId: number | undefined | null;
  product: Product | undefined;
  constructor(private route: ActivatedRoute, private service: ProductService) {
    const observable: Observable<ParamMap> = route.paramMap;
    const observer = {
      next: (result: ParamMap) => {
        const productIdFetched: string | null = result.get("productId");
        if (productIdFetched != null) {
          this.productId = parseInt(productIdFetched);
        }
      }
    };
    observable.subscribe(observer);
  }


}

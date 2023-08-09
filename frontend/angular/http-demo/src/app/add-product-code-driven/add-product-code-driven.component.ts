import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { forbiddenPriceValidator } from '../common/priceValidator';
import { ProductService } from '../product.service';
import { Observable, Observer } from 'rxjs';
import { Product } from '../product';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductCodeDrivenComponent {
  productName: string | undefined;
  price: number | undefined;
  nameCtrl: FormControl;
  priceCtrl: FormControl;
  createdProduct: Product | undefined;
  errMsg:string|undefined;
  myForm: FormGroup;
  constructor(private service: ProductService, builder: FormBuilder) {
    this.nameCtrl = builder.control('',
      [Validators.required, Validators.minLength(2)]);
    this.priceCtrl = builder.control('',
      [Validators.required, forbiddenPriceValidator(0, 1000000)]);
    const controlMappings = {
      productName: this.nameCtrl,
      price: this.priceCtrl
    };
    this.myForm = builder.group(controlMappings);
  }

  addProduct(): void {
    if (!this.myForm.valid) {
      return;
    }
    console.log("inside add product");
    this.productName = this.nameCtrl.value;
    this.price = this.priceCtrl.value;
    const requestData = { name: this.productName, price: this.price };
    const observable: Observable<Product> = this.service.addProduct(requestData);
    const observer:Observer<Product> = {
      next: (result: Product) => {
        this.createdProduct = result;
      },
      error:(err:Error)=>{
        this.errMsg=err.message;
      },
      complete:()=>{console.log("completed successfully");
      }
    }
    observable.subscribe(observer);
  }

  isTouchedOrDirty(control: FormControl): boolean {
    return control.touched || control.dirty;
  }

  isValidForRequired(control: FormControl) {
    if (!this.isTouchedOrDirty(control)) {
      return true;
    }

    return !control.errors?.['required'];
  }

}

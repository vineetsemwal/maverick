import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup,  Validators } from '@angular/forms';

@Component({
  selector: 'add-product-code-driven',
  templateUrl: './add-product-code-driven.component.html',
  styleUrls: ['./add-product-code-driven.component.css']
})
export class AddProductCodeDrivenComponent {
  productName: string | undefined;
  price: number | undefined;
  nameCtrl: FormControl;
  priceCtrl: FormControl;
  myForm: FormGroup;
  constructor(builder: FormBuilder) {
    this.nameCtrl = builder.control('',
    [Validators.required,Validators.minLength(2)]);
    this.priceCtrl = builder.control('',
    [Validators.required,Validators.min(2)]);
    const controlMappings={
      productName: this.nameCtrl,
      price: this.priceCtrl
    };
    this.myForm = builder.group(controlMappings);
  }

  addProduct(): void {
    console.log("inside add product");
    this.productName=this.nameCtrl.value;
    this.price=this.priceCtrl.value;

  }

}

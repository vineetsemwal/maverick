import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { forbiddenPriceValidator } from '../common/priceValidator';

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
      [Validators.required, Validators.minLength(2)]);
    this.priceCtrl = builder.control('',
      [Validators.required, forbiddenPriceValidator(0,1000)]);
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

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { IFormHolder } from '../formHolder';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements IFormHolder{
  productName: string | undefined;
  price: number | undefined;
  nameCtrl: FormControl;
  priceCtrl: FormControl;
  myForm: FormGroup;
  constructor(builder: FormBuilder) {
    this.nameCtrl = builder.control('');
    this.priceCtrl = builder.control('');
    const controlMappings = {
      productName: this.nameCtrl,
      price: this.priceCtrl
    };
    this.myForm = builder.group(controlMappings);
  }
  getFormGroup(): FormGroup<any> {
      return this.myForm;
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

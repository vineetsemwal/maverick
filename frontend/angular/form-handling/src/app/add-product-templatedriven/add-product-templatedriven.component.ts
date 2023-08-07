import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'add-product-templatedriven',
  templateUrl: './add-product-templatedriven.component.html',
  styleUrls: ['./add-product-templatedriven.component.css']
})
export class AddProductTemplatedrivenComponent  {
productName:string|undefined;
price:number|undefined;
output:string|undefined;

addProduct(form:any){
console.log("form values",form.value);
let formData=form.value;
this.productName=formData.productName;
this.price=formData.price;
}
}

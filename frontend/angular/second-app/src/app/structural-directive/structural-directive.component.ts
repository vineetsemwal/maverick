import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'structural-directive',
  templateUrl: './structural-directive.component.html',
  styleUrls: ['./structural-directive.component.css']
})
export class StructuralDirectiveComponent {
num:number=0;
products:Product[]=[
  {name:"samsung", price:20000},
  {name:"moto", price:15000},
]

isEven():boolean{
return this.num%2==0;
}
}

class Product{
  constructor(public name:string, public price:number){}
}

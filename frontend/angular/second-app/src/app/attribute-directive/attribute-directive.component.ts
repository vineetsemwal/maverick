import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'attribute-directive',
  templateUrl: './attribute-directive.component.html',
  styleUrls: ['./attribute-directive.component.css']
})
export class AttributeDirectiveComponent  {
  num:number=11

  isEven():boolean{
    return this.num%2==0;
  }

  colorValue="#fff";
  backgroundColorValue="black";

  styleObj={
    color:this.colorValue,
      backgroundColor:this.backgroundColorValue
  }



}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'property-demo',
  templateUrl: './property-binding.component.html',
  styleUrls: ['./property-binding.component.css']
})
export class PropertyBindingComponent  {

  constructor() { }

  isHidden:boolean=false;

  url="http://google.com";

}

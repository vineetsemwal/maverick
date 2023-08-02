import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'event-binding',
  templateUrl: './event-binding.component.html',
  styleUrls: ['./event-binding.component.css']
})
export class EventBindingComponent {
counter:number=0;
username:string="";

  constructor() { }

  increment():void{
  this.counter++;
  console.log("counter incremented"+this.counter);
  }

  setUserValue(event:any):void{
    this.username=event.target.value
    console.log("username="+this.username);

  }

}

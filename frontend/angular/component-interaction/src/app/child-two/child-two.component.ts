import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-child-two',
  templateUrl: './child-two.component.html',
  styleUrls: ['./child-two.component.css']
})
export class ChildTwoComponent implements OnInit,OnDestroy {

  constructor() { }
  ngOnDestroy(): void {
    console.log("inside child two destroy");
  }

  ngOnInit(): void {
    console.log("inside child two init");
  }


}

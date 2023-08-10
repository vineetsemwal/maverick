import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-child-three',
  templateUrl: './child-three.component.html',
  styleUrls: ['./child-three.component.css']
})
export class ChildThreeComponent implements OnInit, OnDestroy {

  constructor() { }
  ngOnDestroy(): void {
    console.log("inside child three destroy");
  }

  ngOnInit(): void {
    console.log("inside child three init");
  }
}

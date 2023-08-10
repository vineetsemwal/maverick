import { AfterContentInit, AfterViewInit, Component, ContentChild, DoCheck, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChange, SimpleChanges, ViewChild } from '@angular/core';


/**
 *  constructor executed when even component instantiated
 *  ngOnInit : like constructor executed only 1 time, is a recommended place for initialization
 *  ngOnChanges: gets executed after every change in the input bound property,
 *  we get simplechanges object from which we can see previous and the current value
 *  docheck: invoked when change detector of component is executed, called after onchange on every change detection run,
 * you can use it to try detecting change in component but be careful on every doCheck invoke doesn't guarantee a change
 * ngAfterContentInt: called after extenal content has been attached
 * ngAfterViewInit:  called after Angular has fully initialized a component's view
 *
 */

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit,OnDestroy,OnChanges{
  counter: number = 0;
  @Input() parentInput: string | undefined;

  @Output() childEvent: EventEmitter<string> = new EventEmitter();
  sentMessage:string="";
  constructor(){
    console.log("inside child constructor");

  }

  increment() {
    ++this.counter;
    const msg = "message from child counter=" + this.counter;
    this.childEvent.emit(msg);
    this.sentMessage=msg;
    console.log("message sent=" + msg);
  }

ngOnInit(): void {
    console.log("inside Child's ngOnInit");
}

ngOnDestroy(): void {
    console.log("inside Child's ondestroy");
}

ngOnChanges(changes: SimpleChanges): void {
    console.log("inside child's ngonchanges");
   console.log("changes",changes);
   const previous=changes["parentInput"].previousValue;
   const currentVal=changes["parentInput"].currentValue;
   console.log("previous="+previous);
   console.log("current="+currentVal);

}

}

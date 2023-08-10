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
export class ChildComponent  {

  @Input() parentInput: string | undefined;




}

import { Component } from '@angular/core';
import {User, Product}  from './user';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  msg:string="hello angular2";
  user:User=new User("manohar",22);
}


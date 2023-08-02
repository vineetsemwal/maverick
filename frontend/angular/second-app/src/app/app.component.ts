import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 msg:string="Hello Angular2222222";
 user:User=new User("shivam",21);
 getMessage(){
  return "Hi";
 }

}

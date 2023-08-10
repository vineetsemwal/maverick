import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'component-interaction';
  userInput:string|undefined;
  receivedMsg:string="";

  messageReceivedFromChild(message:string){
    console.log("message received in parent");
    console.log("event=",message);
    this.receivedMsg=message;

  }
}

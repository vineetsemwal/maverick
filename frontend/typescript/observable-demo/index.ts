import { Observable, Observer, of } from "rxjs";

const observableObj:Observable<string>=of("apple","mango","banana");

const observer:Observer<string>={
next:(result)=>{
    console.log("result is "+result);    
},
error:(err)=>{
    console.log("error is "+err);    
},
complete:()=>{
    console.log("completed");
    
}
}
observableObj.subscribe(observer);
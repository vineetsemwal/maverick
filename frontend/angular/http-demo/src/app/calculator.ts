import { Adder } from "./adder";

export class Calculator {

    constructor(private adder:Adder){
        
    }

    add(num1:number,num2:number):number{
        console.log("inside add of Calculator",num1,num2);
        const result= this.adder.add(num1,num2);
        return result;
    }

    
    addBy10(num1:number):number{
      console.log("inside add by 10", num1);  
      const result=this.add(num1,10);
      return result; 
    }

}

/*
this when not in function or  method ==global
this inside method will give current object
this when used inside function will give you undefined
*/
class Product{
    constructor(name){
        this.name=name;
       //this.getName=this.getName.bind(this);
    }

    getName(){
      return this.name;
    }

}
const product=new Product("samsung");
const method=product.getName;
const productName=method();
console.log("name="+productName);
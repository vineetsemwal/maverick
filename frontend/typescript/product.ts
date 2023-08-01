class Product{
    
    constructor(private name:string,private price:number){
    }

    display(){
        console.log(this.name+","+this.price);
        
    }
}

const product=new Product("samsung",20000);
product.display();
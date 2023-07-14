class Product {
    constructor(id, name) {
      this._id = id;
      this._name = name;
    }

    get id(){
        console.log("inside getter");
        return this._id;
    }
    set id(idArg){
        console.log("inside setter");
        this._id=idArg;
    }
  }

  const product=new Product(1,"samsung");
  //setter method will be called
  product.id=20;
 // getter method will be called
 const idVal=product.id;
 console.log(idVal);

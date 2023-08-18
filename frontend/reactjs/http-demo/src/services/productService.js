import axios from "axios"

class ProductService{

 baseUrl="http://localhost:5000/products"  ; 

 fetchProducts(){
 const promise=axios.get(this.baseUrl);
 console.log("request sent url=",this.baseUrl);
  return promise;
}    

}

const productService=new ProductService();
export default productService;

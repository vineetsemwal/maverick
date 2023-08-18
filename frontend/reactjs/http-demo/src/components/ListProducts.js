import { useEffect, useState } from "react";
import productService from "../services/productService";
import ProductDetails from "./ProductDetails";

export default function ListProducts(){
  const[products,setProducts]= useState([]);
  const [errMsg,setError]=useState('');

useEffect(()=>{
//fetch data

const promise=productService.fetchProducts();
promise.then(response=>{
setProducts(response.data);    
console.log("fetched products",products);
})
.catch(err=>{
setError(err.message);
console.log("error encountered", err);
})

},[]);
if(products)
{
    return(
   <div>
{products.map(product=><ProductDetails product={product} key={product.id} />)}
</div>
)
    }
return (
<div>
 Error is {errMsg}   
</div>

)

}

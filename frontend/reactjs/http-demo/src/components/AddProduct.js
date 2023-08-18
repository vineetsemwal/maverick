import { event } from "jquery";
import { useState } from "react";
import productService from "../services/productService";

export default function AddProduct() {
  let [product, setProduct] = useState({ name: "", price: -1 });
  let errMsg;
  const submitHandler = (event) => {
    event.preventDefault();
    const promise = productService.addProduct(product);
    promise
      .then((response) => {
        setProduct(response.data);
        console.log("added product",product)
    }
        )
      .catch((err) => (errMsg = err.message));
  };

  const changeHandler = (event) => {
    console.log("inside name handler", event);
    const value = event.target.value;
    const fieldName = event.target.name;
    product = { ...product, [fieldName]: value };
    setProduct(product);
  };
  return (
    <div>
      <form onSubmit={event=>submitHandler(event)}>
        <div>
          <label>Product Name</label>
          <input name="name" onChange={(event) => changeHandler(event)} />
        </div>

        <div>
          <label>Product Price</label>
          <input
            type="number"
            name="price"
            onChange={(event) => changeHandler(event)}
          />
        </div>
        <button>Submit</button>
      </form>

      <div>
        <h3>Entered Product</h3>
        {product.name} ,{product.price}
      </div>

      <div>
        <h3>Added Product</h3>
        {product.id} , {product.name}, {product.price}
      </div>
    </div>
  );
}

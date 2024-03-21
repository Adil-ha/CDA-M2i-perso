import React, { useState } from 'react';
import { productService } from '../services/productService';
import { useNavigate } from 'react-router-dom';


function CreateProduct() {

    const navigate = useNavigate();
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  
  const handleSubmit = (event) => {
    event.preventDefault();

         productService.createProduct({name, price});
        navigate('/products'); 

  };


  return (
    <div className="container mt-5">
      <h2>Create Product</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="productName">Name:</label>
          <input
            type="text"
            className="form-control"
            id="productName"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter product name"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="productPrice">Price:</label>
          <input
            type="number"
            className="form-control"
            id="productPrice"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            placeholder="Enter product price"
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default CreateProduct;

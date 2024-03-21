import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import { getUserDetails } from '../helpers/user-details';

function ProductList() {

  const userDetails = getUserDetails();
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, []);

  const isAdmin = () => {
    return userDetails && userDetails.role === 'ROLE_ADMIN';
};


  const handleDelete = (productId) => {
      productService.deleteProduct(productId)
      setProducts(products.filter((p) => p.id != productId))
  };

  const handleUpdate = (productId) => {
    // Logique de mise à jour du produit avec l'identifiant `productId`
  };

  return (
    <div className="container mt-5">
      <h2>Product List</h2>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            {isAdmin() && (<th scope="col">Actions</th>)}
            
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id}>
              <th scope="row">{index + 1}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              {isAdmin() && ( <td>
                <button className="btn btn-danger mr-2" onClick={() => handleDelete(product.id)}>Delete</button>
                <button className="btn btn-primary" onClick={() => handleUpdate(product.id)}>Update</button>
              </td>)}
             
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;

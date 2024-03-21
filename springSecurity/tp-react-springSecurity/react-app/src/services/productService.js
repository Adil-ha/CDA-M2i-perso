import api from './api';
import { authHeader } from '../helpers/auth-header';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};

const createProduct = (product) => {
  return api.post('/products/admin/post',product, { headers: authHeader() });
};

const deleteProduct = (idProduct) => {
  return api.delete(`/products/${idProduct}`, { headers: authHeader() });
};



export const productService = { getAllProducts, createProduct, deleteProduct};

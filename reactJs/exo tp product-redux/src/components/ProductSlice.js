import { createSlice } from "@reduxjs/toolkit";

const productSlice = createSlice({
  name: "products",
  initialState: {
    products: [{ id: 1, text: "Haricot", price: 2 }],
  },
  reducers: {
    addProduct: (state, action) => {
      const { text, price } = action.payload;
      const newProduct = {
        id: Date.now(),
        text,
        price,
      };
      state.products.push(newProduct);
    },
    deleteProduct: (state, action) => {
      state.products = state.products.filter((p) => p.id !== action.payload);
    },
    editProduct: (state, action) => {
      const { id, newText, newPrice } = action.payload;
      const productIndex = state.products.findIndex((p) => p.id === id);

      if (productIndex !== -1) {
        state.products[productIndex].text = newText;
        state.products[productIndex].price = newPrice;
      }
    },
  },
});

export const { addProduct, deleteProduct, editProduct } = productSlice.actions;
export default productSlice.reducer;

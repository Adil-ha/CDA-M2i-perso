import { configureStore } from "@reduxjs/toolkit";
import ProductSlice from "./components/ProductSlice";

const store = configureStore({
  reducer: {
    product: ProductSlice,
  },
});

export default store;

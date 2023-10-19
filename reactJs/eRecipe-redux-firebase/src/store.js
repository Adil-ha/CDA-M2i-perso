import authSlice from "./components/auth/authSlice";
import { configureStore } from "@reduxjs/toolkit";
import recipesSlice from "./components/recipe/recipesSlice";

export default configureStore({
  reducer: {
    auth: authSlice,
    recipe: recipesSlice,
  },
});

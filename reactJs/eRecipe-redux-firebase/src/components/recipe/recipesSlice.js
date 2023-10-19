import { createSlice } from "@reduxjs/toolkit";

const recipesSlice = createSlice({
  name: "recipe",
  initialState: {
    formMode: "",
    recipes: [],
    selectedRecipe: null,
    ingredients: [],
    isLoading: false,
    error: null,
  },
  reducers: {
    addRecipe: (state, action) => {
      state.recipes.push(action.payload);
    },
    deleteRecipe: (state, action) => {
      state.recipes = state.recipes.filter(
        (recipe) => recipe.id !== action.payload
      );
    },
    updateRecipe: (state, action) => {
      const updatedRecipe = action.payload;
      const index = state.recipes.findIndex(
        (recipe) => recipe.id === updatedRecipe.id
      );
      if (index !== -1) {
        state.recipes[index] = updatedRecipe;
      }
    },
    setFormMode: (state, action) => {
      state.formMode = action.payload;
    },
    setSelectedRecipe: (state, action) => {
      state.selectedRecipe = action.payload;
    },
    setIngredients: (state, action) => {
      state.ingredients = action.payload;
    },
    setLoading: (state, action) => {
      state.isLoading = action.payload;
    },
    setError: (state, action) => {
      state.error = action.payload;
    },
  },
});

export const {
  addRecipe,
  deleteRecipe,
  updateRecipe,
  setFormMode,
  setSelectedRecipe,
  setIngredients,
  setLoading,
  setError,
} = recipesSlice.actions;

export default recipesSlice.reducer;

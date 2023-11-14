import {configureStore} from '@reduxjs/toolkit';
import pokemonSlice from '../data/pokemonSlice';

export const store = configureStore({
  reducer: {
    pokemon: pokemonSlice,
  },
});

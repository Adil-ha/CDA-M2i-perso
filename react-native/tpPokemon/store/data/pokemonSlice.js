import {createSlice, createAsyncThunk} from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_API_URL = 'https://pokeapi.co/api/v2/pokemon';

export const fetchAllPokemons = createAsyncThunk(
  'pokemon/fetchAllPokemons',
  async () => {
    try {
      const response = await axios.get(`${BASE_API_URL}?offset=10&limit=50`);
      const pokemonRequests = response.data.results.map(p => axios.get(p.url));

      const pokemonResponses = await Promise.all(pokemonRequests);

      const tab = pokemonResponses.map(res => res.data);
      return tab;
    } catch (error) {
      throw error;
    }
  },
);

export const fetchPokemonById = createAsyncThunk(
  'pokemon/fetchPokemonById',
  async pokemonId => {
    try {
      const response = await axios.get(`${BASE_API_URL}/${pokemonId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
);

const pokemonSlice = createSlice({
  name: 'pokemon',
  initialState: {
    pokemons: [],
    selectedPokemon: null,
  },
  reducers: {},
  extraReducers: builder => {
    builder.addCase(fetchAllPokemons.fulfilled, (state, action) => {
      state.pokemons = action.payload;
    });

    builder.addCase(fetchPokemonById.fulfilled, (state, action) => {
      state.selectedPokemon = action.payload;
    });
  },
});

export default pokemonSlice.reducer;

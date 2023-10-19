import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../fireBaseConfig";

export const fetchAlbum = createAsyncThunk(
  "albumItems/fetchAlbum",
  async () => {
    const response = await fetch(BASE_DB_URL + "/eAlbum.json");
    const data = await response.json();
    const albums = [];
    for (const key in data) {
      albums.push({ id: key, ...data[key] });
    }
    return albums;
  }
);

export const postAlbum = createAsyncThunk(
  "albumItems/postAlbum",
  async (newAlbum) => {
    const token = localStorage.getItem("token");
    const response = await fetch(`${BASE_DB_URL}/eAlbum.json?auth=${token}`, {
      method: "POST",
      headers: {
        "Content-Type": "application.json",
      },
      body: JSON.stringify(newAlbum),
    });
    const data = await response.json();
    return {
      id: data.name,
      ...newAlbum,
    };
  }
);

export const updateAlbum = createAsyncThunk(
  "albumItems/updateAlbum",
  async (updatedAlbum) => {
    const token = localStorage.getItem("token");
    if (!token) {
      console.error("No token found in local storage. Please log in.");
      return thunkAPI.rejectWithValue(
        "Aucun jeton trouvé dans le stockage local"
      );
    }
    const response = await fetch(
      `${BASE_DB_URL}/eAlbum/${updatedAlbum.id}.json?auth=${token}`,
      {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedAlbum),
      }
    );
    if (response.ok) {
      return updatedAlbum;
    } else {
      throw new Error("La mise à jour de l'album a échoué.");
    }
  }
);

export const deleteAlbum = createAsyncThunk(
  "albumItems/deleteAlbum",
  async (albumId) => {
    const token = localStorage.getItem("token");
    if (!token) {
      console.error("No token found in local storage. Please log in.");
      return thunkAPI.rejectWithValue(
        "Aucun jeton trouvé dans le stockage local"
      );
    }
    const response = await fetch(
      `${BASE_DB_URL}/eAlbum/${albumId}.json?auth=${token}`,
      {
        method: "DELETE",
      }
    );
    if (response.ok) {
      return albumId; // Retournez l'ID de l'album supprimé
    } else {
      // Gérez les erreurs ici si la suppression a échoué
      throw new Error("La suppression de l'album a échoué.");
    }
  }
);

const albumItemsSlice = createSlice({
  name: "albumItems",
  initialState: {
    albums: [],
  },
  reducers: {},
  /*
        .fulfilled -> L'action se déclenche si la requête se termine
        .rejected -> L'action se déclenche si la requête echoue
        .pending -> L'action se déclenche pendant la requête
    */
  extraReducers: (builder) => {
    builder.addCase(fetchAlbum.fulfilled, (state, action) => {
      state.albums = action.payload;
      console.log(state.albums);
    });
    builder.addCase(postAlbum.fulfilled, (state, action) => {
      state.albums.push(action.payload);
    });
    builder.addCase(deleteAlbum.fulfilled, (state, action) => {
      // Supprimez l'album de state.albums en utilisant action.payload (qui contient l'ID de l'album supprimé)
      state.albums = state.albums.filter(
        (album) => album.id !== action.payload
      );
    });
    builder.addCase(updateAlbum.fulfilled, (state, action) => {
      // Mettez à jour l'album dans state.albums avec les données mises à jour
      const index = state.albums.findIndex(
        (album) => album.id === action.payload.id
      );
      if (index !== -1) {
        state.albums[index] = action.payload;
      }
    });
  },
});

export default albumItemsSlice.reducer;

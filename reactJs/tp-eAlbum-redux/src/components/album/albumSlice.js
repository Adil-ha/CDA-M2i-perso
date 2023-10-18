import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../fireBaseConfig";

export const fetchAlbums = createAsyncThunk(
  "albumItems/fetchAlbums",
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
    const response = await fetch(BASE_DB_URL + "/eAlbum.json", {
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
    // Envoyez une requête pour mettre à jour l'album avec les nouvelles données
    const response = await fetch(
      `${BASE_DB_URL}/eAlbum/${updatedAlbum.id}.json`,
      {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedAlbum),
      }
    );
    if (response.ok) {
      return updatedAlbum; // Retournez les données mises à jour de l'album
    } else {
      // Gérez les erreurs ici si la mise à jour a échoué
      throw new Error("La mise à jour de l'album a échoué.");
    }
  }
);

export const deleteAlbum = createAsyncThunk(
  "albumItems/deleteAlbum",
  async (albumId) => {
    // Envoyez une requête pour supprimer l'album correspondant à l'ID
    const response = await fetch(`${BASE_DB_URL}/eAlbum/${albumId}.json`, {
      method: "DELETE",
    });
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
    builder.addCase(fetchAlbums.fulfilled, (state, action) => {
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

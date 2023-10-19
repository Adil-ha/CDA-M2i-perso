import React from "react";
import AlbumItem from "./AlbumItem";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { fetchAlbum } from "./albumSlice";

const AlbumDisplay = () => {
  const albums = useSelector((state) => state.albums.albums);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchAlbum());
  }, []);

  return (
    <div className="container">
      <div className="row my-3">
        <div className="col-12">
          <h3 className="text-center">Albums List</h3>
          <hr />
        </div>
      </div>

      <div className="row">
        {albums.length === 0 ? (
          <div className="col-12">
            <p className="text-center">
              Aucun album disponible pour le moment!
            </p>
          </div>
        ) : (
          albums.map((album) => (
            <div key={album.id} className="col-md-3">
              <AlbumItem album={album} />
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default AlbumDisplay;

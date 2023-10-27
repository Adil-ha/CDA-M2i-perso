import React from "react";
import { useDispatch } from "react-redux";
import { deleteAlbum } from "./albumSlice";
import { useNavigate } from "react-router-dom";
import "font-awesome/css/font-awesome.min.css";

const renderStars = (score, maxScore = 5) => {
  const starArray = [];
  for (let i = 1; i <= maxScore; i++) {
    starArray.push(
      <span key={i} className={`fa fa-star${i <= score ? " checked" : ""}`} ></span>
    );
  }
  return starArray;
};

const AlbumItem = (props) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const album = props.album;
  const hasToken = localStorage.getItem("token");

  const handleDelete = () => {
    dispatch(deleteAlbum(album.id));
  };

  const handleUpdate = () => {
    navigate("/addAlbum?mode=edit&id=" + album.id);
  };

  return (
    <div className="card mb-3">
      <h3 className="card-header">{album.title}</h3>
      <img
        src={`./cover/${album.cover}.jpg`}
     

        alt={album.title}
        className="d-block user-select-none object-fit-fill"
        width="100%"
        height="200"
        aria-label={`Album Cover: ${album.title}`}
        focusable="false"
        role="img"
        preserveAspectRatio="xMidYMid slice"
        style={{ fontSize: "1.125rem", textAnchor: "middle" }}
      />
      <div className="card-body">
        <p className="card-text">{album.artist}</p>
        <hr />
        <p className="card-text">{album.releaseDate}</p>
        <hr />
        
        <div className="card-text">{renderStars(album.score)}</div>
      </div>
      <div className="card-footer d-flex justify-content-end">
        {hasToken && (
          <>
            <button className="btn btn-danger me-1" onClick={handleDelete}>
              Supprimer
            </button>
            <button className="btn btn-warning" onClick={handleUpdate}>
              Modifier
            </button>
          </>
        )}
      </div>
    </div>
  );
};

export default AlbumItem;
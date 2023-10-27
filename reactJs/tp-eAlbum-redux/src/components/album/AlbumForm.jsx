import { useDispatch, useSelector } from "react-redux";
import { useRef, useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { postAlbum, updateAlbum } from "./albumSlice";

const AlbumForm = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [searchparam] = useSearchParams();
  const mode = searchparam.get("mode");
  const id = searchparam.get("id");

  const albums = useSelector((state) => state.albums.albums);

  const titleRef = useRef();
  const releaseDateRef = useRef();
  const artistRef = useRef();
  const scoreRef = useRef();
  const coverRef = useRef();


  const findAlbumById = (albumId) => {
    return albums.find((album) => album.id === albumId);
  };


  const populateForm = (album) => {
    titleRef.current.value = album.title;
    releaseDateRef.current.value = album.releaseDate;
    artistRef.current.value = album.artist;
    scoreRef.current.value = album.score;
    coverRef.current.value = album.cover;
  };
  


  useEffect(() => {
  
    if (mode === "edit" && id) {
      const albumToEdit = findAlbumById(id);
      if (albumToEdit) {
        populateForm(albumToEdit);
      }
    }
  }, [mode, id]);

  const submitFormHandler = (event) => {
    event.preventDefault();

    const albumData = {
      title: titleRef.current.value,
      releaseDate: releaseDateRef.current.value,
      artist: artistRef.current.value,
      score: scoreRef.current.value,
      cover: coverRef.current.value,
    };

    if (mode === "edit" && id) {
      const updatedAlbum = { id, ...albumData };

      dispatch(updateAlbum(updatedAlbum));
    } else {

      dispatch(postAlbum(albumData));
    }

    navigate("/");
  };

  return (
    <>
      <h1>{mode === "edit" ? "Edit Form" : "Add Form"}</h1>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">
            Title :
          </label>
          <input type="text" className="form-control" required ref={titleRef} />
        </div>
        <div className="mb-3">
          <label htmlFor="releaseDate" className="form-label">
            Release Date :
          </label>
          <input
            type="date"
            className="form-control"
            required
            ref={releaseDateRef}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="prepTime" className="form-label">
            Artist :
          </label>
          <input
            type="text"
            className="form-control"
            required
            ref={artistRef}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="instructions" className="form-label">
            Score :
          </label>
          <input
            type="number"
            className="form-control"
            required
            ref={scoreRef}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ingredients" className="form-label">
            Cover :
          </label>
          <input type="text" ref={coverRef} className="form-control" />
        </div>
        <div className="text-end">
          <button className="btn btn-success">
            {mode === "edit" ? "Update" : "Add"}
          </button>
        </div>
      </form>
    </>
  );
};

export default AlbumForm;

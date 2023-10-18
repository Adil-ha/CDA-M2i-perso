import AlbumDisplay from "./components/album/AlbumDisplay";
import NavBar from "./shared/NavBar";
import { useDispatch, useSelector } from "react-redux";

function App() {
  const user = useSelector((state) => state.auth.user);
  const albums = useSelector((state) => state.albums.albums);
  const dispatch = useDispatch();
  return (
    <>
      <header>
        <NavBar />
      </header>
      <main className="container">
        <div className="row my-3">
          <div className="col-10 offset-1 bg-dark rounded text-light p-3">
            <div className="d-flex justify-content-between align-items-center">
              <h3>Albums List</h3>
              {/* {user && <button className='btn btn-success' onClick={() => dispatch(setFormMode("add"))}>Add</button>} */}
            </div>
            <hr />
            {albums.length === 0 ? (
              <p>Aucun album disponible pour le moment !</p>
            ) : (
              albums.map((album) => (
                <AlbumDisplay key={album.id} album={album} />
              ))
            )}
          </div>
        </div>
      </main>
    </>
  );
}

export default App;

import { useDispatch, useSelector } from "react-redux";
import { Link, NavLink, useNavigate } from "react-router-dom";
import { removeUser, setAuthMode } from "../components/auth/authSlice";
import Modal from "./Modal";
import SignForm from "../components/auth/SignForm";

const NavBar = () => {
  const user = useSelector((state) => state.auth.user);
  const authMode = useSelector((state) => state.auth.authMode);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleLogout = () => {
    dispatch(removeUser());
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <>
      {authMode && (
        <Modal onClose={() => dispatch(setAuthMode(""))}>
          <SignForm />
        </Modal>
      )}
      <nav
        className="navbar navbar-expand-lg bg-body-tertiary"
        data-bs-theme="dark"
      >
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            eAlbum
          </Link>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink className="nav-link" to={`/`}>
                  Accueil
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to={`/addAlbum`}>
                  Ajout album
                </NavLink>
              </li>
            </ul>
          </div>
          <button
            onClick={
              () =>
                !user ? dispatch(setAuthMode("Se connecter")) : handleLogout() // Call the handleLogout function
            }
            className="ms-auto btn btn-info"
          >
            {user ? "Déconnexion" : "Se connecter"}
          </button>
        </div>
      </nav>
    </>
  );
};

export default NavBar;

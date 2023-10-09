import { NavLink, Outlet } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Menu() {
  return (
    <>
      <header>
        <nav className="navbar navbar-expand-lg bg-dark text-light">
          <h1>eWebsite</h1>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item text-light">
                <NavLink to="/">Accueil</NavLink>
              </li>
              <li className="nav-item text-light">
                <NavLink to="/Project">Projets</NavLink>
              </li>
              <li className="nav-item text-light">
                <NavLink to="/Contact">Contacter moi</NavLink>
              </li>
              <li className="nav-item text-light">
                <NavLink to="/Abou">A propos</NavLink>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <Outlet />
    </>
  );
}

export default Menu;

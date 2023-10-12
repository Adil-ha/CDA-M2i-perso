import { Link, NavLink, Outlet } from "react-router-dom";
import { useState } from "react";
import CarsContext from "./contexts/CarsContext";
import CartContext from "./contexts/CartContext";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [cars, setCars] = useState([]);
  const [cart, setCart] = useState([]);
  return (
    <CarsContext.Provider value={{ cars, setCars }}>
      <CartContext.Provider value={{ cart, setCart }}>
        <div className="App">
          <header>
            <nav
              className="navbar navbar-expand-lg bg-body-tertiary"
              data-bs-theme="dark"
            >
              <div className="container-fluid">
                <Link className="navbar-brand" href="#">
                  eCar
                </Link>
                <button
                  className="navbar-toggler"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#navbarNav"
                  aria-controls="navbarNav"
                  aria-expanded="false"
                  aria-label="Toggle navigation"
                >
                  <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                  <ul className="navbar-nav">
                    <li className="nav-item">
                      <NavLink className="nav-link" to={`/`}>
                        Accueil
                      </NavLink>
                    </li>
                    <li className="nav-item">
                      <NavLink className="nav-link" to={`/cart`}>
                        Panier
                      </NavLink>
                    </li>
                    <li className="nav-item">
                      <NavLink className="nav-link" to={`/formAdmin`}>
                        Administrateur
                      </NavLink>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>
          </header>
          <main className="container">
            <div className="row my-3">
              <div className="col-10 offset-1 rounded p-3 bg-dark text-light">
                <Outlet />
              </div>
            </div>
          </main>
        </div>
      </CartContext.Provider>
    </CarsContext.Provider>
  );
}

export default App;

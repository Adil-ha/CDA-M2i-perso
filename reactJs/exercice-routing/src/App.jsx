import { Link, NavLink, Outlet } from "react-router-dom";
import ContactContext from "./contexts/ContactContext";
import { useState } from "react";

function App() {
  const [contacts, setContacts] = useState([]);
  return (
    <ContactContext.Provider value={{ contacts, setContacts }}>
      <div className="App">
        <header>
          <nav
            className="navbar navbar-expand-lg bg-body-tertiary"
            data-bs-theme="dark"
          >
            <div className="container-fluid">
              <NavLink className="navbar-brand" to={`/ListContact`}>
                eContact
              </NavLink>

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
                    <NavLink className="nav-link" to={`/contact`}>
                      Contacts
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
    </ContactContext.Provider>
  );
}

export default App;

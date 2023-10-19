import { Outlet } from "react-router-dom";
import NavBar from "./shared/NavBar";

function App() {
  return (
    <>
      <header>
        <NavBar />
      </header>
      <main>
        <div className="row my-3">
          <div className="col-10 offset-1 rounded p-3 bg-dark text-light">
            <Outlet />
          </div>
        </div>
      </main>
    </>
  );
}

export default App;

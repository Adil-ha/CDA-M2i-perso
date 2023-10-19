import { useSelector } from "react-redux";

import AddRecipes from "./components/recipe/addRecipe";
import SignForm from "./components/auth/SignForm";
import ListRecipe from "./components/recipe/ListRecipe";

function App() {
  const user = useSelector((state) => state.auth.user);

  return (
    <>
      {user ? (
        <div className="row g-3 ">
          <div className="col-4">
            <AddRecipes user={user} />{" "}
          </div>
          <div className="col-8">
            <div className="bg-dark text-light p-3 rounded">
              <h3>Recipes List</h3>
              <hr />
              <div className="d-flex flex-column" id="recipesContainer">
                <ListRecipe user={user} />
              </div>
            </div>
          </div>
        </div>
      ) : (
        <SignForm />
      )}
    </>
  );
}

export default App;

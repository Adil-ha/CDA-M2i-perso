import { useRef } from "react";
import { useDispatch } from "react-redux";
import { removeUser } from "../auth/authSlice";
import { BASE_DB_URL } from "../../fireBaseConfig";
import { addRecipe } from "./recipesSlice";

const AddRecipes = (props) => {
  const user = props.user;
  const dispatch = useDispatch();

  const nameRef = useRef();
  const instructionRef = useRef();
  const prepTimeRef = useRef();
  const prepCookRef = useRef();
  const ingredientRef = useRef();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      !nameRef.current.value ||
      !prepTimeRef.current.value ||
      !prepCookRef.current.value
    ) {
      alert("Tous les champs obligatoires doivent être remplis.");
      return;
    }

    const newRecipe = {
      id: Date.now(),
      title: nameRef.current.value,
      instructions: instructionRef.current.value,
      preparationTime: +prepTimeRef.current.value,
      cookingTime: +prepCookRef.current.value,
      ingredients: ingredientRef.current.value,
    };

    if (user.idToken) {
      try {
        const response = await fetch(
          `${BASE_DB_URL}/eRecipes.json?auth=${user.idToken}`,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(newRecipe),
          }
        );
        if (!response.ok) {
          throw new Error("Something went wrong during the POST request !");
        }
        const data = await response.json();

        console.log(data);

        nameRef.current.value = "";
        instructionRef.current.value = "";
        prepTimeRef.current.value = "";
        prepCookRef.current.value = "";
        ingredientRef.current.value = "";

        dispatch(addRecipe(newRecipe));
      } catch (error) {
        console.error(error.message);
      }
    }
  };
  return (
    <>
      <button className="btn btn-danger" onClick={() => dispatch(removeUser())}>
        Déconexion
      </button>
      <form onSubmit={handleSubmit}>
        <div className="bg-dark text-light p-3 rounded">
          <h3>Add recipes</h3>
          <hr />
          <div className="mb-3">
            <label htmlFor="filter-name" className="form-label">
              Name:
            </label>
            <input
              ref={nameRef}
              type="text"
              className="form-control"
              name="filter-name"
              id="filter-name"
            />
          </div>
          <div className="mb-3">
            <label htmlFor="filter-instruction" className="form-label">
              Instructions:
            </label>
            <input
              ref={instructionRef}
              type="text"
              className="form-control"
              name="filter-instruction"
              id="filter-instruction"
            />
          </div>
          <div className="mb-3">
            <label htmlFor="filter-prepTime" className="form-label">
              Preparation time:
            </label>
            <input
              ref={prepTimeRef}
              type="number"
              className="form-control"
              name="filter-prepTime"
              id="filter-prepTime"
            />
          </div>
          <div className="mb-3">
            <label htmlFor="filter-cookTime" className="form-label">
              Cooking time:
            </label>
            <input
              ref={prepCookRef}
              type="number"
              className="form-control"
              name="filter-cookTime"
              id="filter-cookTime"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="filter-name" className="form-label">
              Ingredients
            </label>
            <input
              ref={ingredientRef}
              type="text"
              className="form-control"
              name="filter-name"
              id="filter-name"
            />
          </div>

          <hr />
          <button className="btn btn-outline-light w-100">Add recipe</button>
        </div>
      </form>
    </>
  );
};

export default AddRecipes;

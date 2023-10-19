import React from "react";

const ItemRecipe = ({ recipe, onDelete }) => {
  const handleDeleteClick = () => {
    onDelete(recipe.id);
  };
  return (
    <>
      <div className="border border-info rounded p-3 mb-2">
        <div className="d-flex justify-content-between">
          <h3>{recipe.title}</h3>
          <div className="d-flex">
            <button>{recipe.prepTime} min</button>

            <button>{recipe.cookTime} min</button>
          </div>
        </div>
        <hr />
        <div className="row">
          <div className="col-4">
            <h5>Ingredients</h5>
            <hr />
            <ul>
              {recipe.ingredients.split(",").map((ingredient, index) => (
                <li key={index}>{ingredient}</li>
              ))}
            </ul>
          </div>
          <div className="col-8">
            <h5>Instructions</h5>
            <hr />
            <ul>
              <li>{recipe.instructions}</li>
            </ul>
          </div>
        </div>
        <hr />
        <div className="d-flex">
          <button className="btn btn-warning me-2">Edit</button>
          <button onClick={handleDeleteClick} className="btn btn-danger">
            Delete
          </button>
        </div>
      </div>
    </>
  );
};

export default ItemRecipe;

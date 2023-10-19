import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import ItemRecipe from "./ItemRecipe";
import { BASE_DB_URL } from "../../fireBaseConfig";
import { deleteRecipe } from "./recipesSlice";

const ListRecipe = (props) => {
  const user = props.user;

  const dispatch = useDispatch();
  const [recipes, setRecipes] = useState([]);

  useEffect(() => {
    fetch(`${BASE_DB_URL}/eRecipes.json`)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        const recipesData = Object.values(data);
        setRecipes(recipesData);
      })
      .catch((error) => {
        console.error(
          "Erreur lors de la récupération des recettes depuis l'API:",
          error
        );
      });
  }, []);

  const handleDeleteRecipe = (recipeId) => {
    console.log(recipeId);
    dispatch(deleteRecipe(recipeId));

    fetch(`${BASE_DB_URL}/eRecipes/${recipeId}.json?auth=${user.idToken}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then(() => {
        console.log("Recette supprimée avec succès de l'API.");
      })
      .catch((error) => {
        console.error(
          "Erreur lors de la suppression de la recette depuis l'API:",
          error
        );
      });
  };

  return (
    <>
      {recipes.map((recipe, index) => (
        <ItemRecipe recipe={recipe} key={index} onDelete={handleDeleteRecipe} />
      ))}
    </>
  );
};

export default ListRecipe;

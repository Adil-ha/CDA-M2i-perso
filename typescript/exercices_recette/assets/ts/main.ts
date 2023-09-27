import { IRecipe } from "./Interface/IRecipe.js";
import { recipeData } from "./data/recipeData.js";

const recipeContent = document.querySelector(".recipeContent") as HTMLBodyElement

const recipeList : IRecipe [] = []

for (const key in recipeData) {
    if (recipeData.hasOwnProperty(key)) {
      const recetteData = recipeData[key];
      
      const recette: IRecipe = {
        id: key,
        name: recetteData.name,
        servings: recetteData.servings,
        prepTime: recetteData.prepTime,
        cookTime: recetteData.cookTime,
        ingredients: recetteData.ingredients,
        instructions: recetteData.instructions,
      };
      
      recipeList.push(recette);
    }
  }
  
 
  console.table(recipeList);

recipeList.forEach(recipe => {
  const recipeDiv = document.createElement('div');
  
  recipeDiv.classList.add('mb-3', 'w-100', 'rounded', 'recipe');
  recipeDiv.id = `${recipe.id}`;
  
  const titleElement = document.createElement('h3');
  titleElement.classList.add('fw-bold', 'text-light', 'text-center');
  titleElement.textContent = `${recipe.name}`;
  
  const hrElement = document.createElement('hr');
  hrElement.classList.add('text-light');
  
  const timeDiv = document.createElement('div');
  timeDiv.classList.add('d-flex', 'justify-content-around');

  const prepTimeElement = document.createElement('p');
  prepTimeElement.classList.add('text-light');
  prepTimeElement.textContent = `${recipe.prepTime}`;
  
  const cookTimeElement = document.createElement('p');
  cookTimeElement.classList.add('text-light');
  cookTimeElement.textContent = `${recipe.cookTime}`;
  
  timeDiv.appendChild(prepTimeElement);
  timeDiv.appendChild(cookTimeElement);
  
  recipeDiv.appendChild(titleElement);
  recipeDiv.appendChild(hrElement);
  recipeDiv.appendChild(timeDiv);
  
  recipeContent.appendChild(recipeDiv);
    
});

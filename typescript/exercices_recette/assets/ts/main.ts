import { IRecipe } from "./Interface/Irecipe.js";
import { recipeData } from "./data/recipeData.js";

const recipeContent = document.querySelector(
  ".recipeContent"
) as HTMLBodyElement;
const modal = document.querySelector(".myModal") as HTMLBodyElement;
const inputRangePreparation = document.querySelector(
  ".inputRangePreparation"
) as HTMLInputElement;
const inputRangeCooking = document.querySelector(
  ".inputRangeCooking"
) as HTMLInputElement;
console.log(inputRangeCooking);
const rangeValuePreparation = document.querySelector(
  ".rangeValuePreparation"
) as HTMLBodyElement;
const rangeValueCooking = document.querySelector(
  ".rangeValueCooking"
) as HTMLBodyElement;
const nameInput = document.getElementById("nameInput") as HTMLInputElement;

const recipeList: IRecipe[] = [];

function getRecipe() {
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

  displayRecipe();
  displayIngredientsInSelect();
}
function createRecipeElement(recipe: IRecipe) {
  recipeContent.innerHTML += `
    <div class="mb-3 w-100 rounded recipe" id="${recipe.id}">
      <h3 class="fw-bold text-light text-center">${recipe.name}</h3>
      <hr class="text-light">
      <div class="d-flex justify-content-around">
        <p class="text-light">Preparation Time: ${recipe.prepTime}</p>
        <p class="text-light">Cooking Time: ${recipe.cookTime}</p>
      </div>
    </div>
  `;
}
function displayRecipe() {
  recipeList.forEach((recipe) => {
    createRecipeElement(recipe);
  });
  displayModal();
}

function displayModal() {
  const recipeItems = document.querySelectorAll(".recipe");
  recipeItems.forEach((element) => {
    element.addEventListener("click", () => {
      const id: string = element.id;
      createModal(id);
      modal.style.display = "block";
    });
  });
}

function createModal(id: string) {
  const recipe = recipeList.find((r) => r.id === id);

  if (!recipe) {
    console.error("Recipe not found");
    return;
  }

  const row = document.createElement("row");
  row.classList.add("row");

  modal.innerHTML = "";

  row.innerHTML = `
    
      <div class="col-4">
        <h6>Preparation Time</h6>
        <p>${recipe.prepTime}</p>
        <h6>Cooking Time</h6>
        <p>${recipe.cookTime}</p>
        <h6>Servings</h6>
        <p>${recipe.servings} servings</p>
        <h6>Ingredients</h6>
        <ul>
          ${recipe.ingredients
            .map((ingredient) => `<li>${ingredient.name}</li>`)
            .join("")}
        </ul>
      </div>
      <div class="col-8 right">
        <div class="close">
          <i class="bi bi-x-lg"></i>
        </div>
        <h4>${recipe.name}</h4>
        <hr />
        <ul>
          ${recipe.instructions
            .map((instruction) => `<li>${instruction}</li>`)
            .join("")}
        </ul>
      </div>
    
  `;
  modal.appendChild(row);

  closeModal();
}

function closeModal() {
  const btnModalClose = document.querySelector(".close");
  if (btnModalClose) {
    btnModalClose.addEventListener("click", () => {
      modal.style.display = "none";
    });
  }
}

function displayIngredientsInSelect() {
  const uniqueIngredients = new Set<string>();

  recipeList.forEach((recipe) => {
    recipe.ingredients.forEach((ingredient) => {
      uniqueIngredients.add(ingredient.name);
    });
  });

  const selectElement = document.getElementById(
    "IngredientSelect"
  ) as HTMLBodyElement;

  uniqueIngredients.forEach((ingredientName) => {
    const option = document.createElement("option");
    option.text = ingredientName;
    selectElement.appendChild(option);
  });
}

function filter() {
  const searchTerm = nameInput.value.toLowerCase();
  const minPrepTime = parseInt(inputRangePreparation.value);
  console.log(minPrepTime);
  const minCookTime = parseInt(inputRangeCooking.value);
  console.log(minCookTime);

  const filteredRecipes = recipeList.filter((recipe) => {
    const recipeName = recipe.name.toLowerCase();
    const prepTime = parseInt(recipe.prepTime.split(" ")[0]);
    const cookTime = parseInt(recipe.cookTime.split(" ")[0]);

    return (
      recipeName.includes(searchTerm) &&
      prepTime <= minPrepTime &&
      cookTime <= minCookTime
    );
  });

  recipeContent.innerHTML = "";

  filteredRecipes.forEach((recipe) => {
    createRecipeElement(recipe);
  });

  displayModal();
}

window.addEventListener("load", getRecipe);
console.log(recipeList);

inputRangePreparation.addEventListener("input", () => {
  filter();
  rangeValuePreparation.textContent = `Preparation time : ${inputRangePreparation.value} min`;
});

inputRangeCooking.addEventListener("input", () => {
  filter();
  rangeValueCooking.textContent = `Cooking time : ${inputRangeCooking.value} min`;
});

nameInput.addEventListener("input", filter);

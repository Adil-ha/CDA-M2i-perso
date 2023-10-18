import { IRecipe } from "./Interface/IRecipe.js";
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
const rangeValuePreparation = document.querySelector(
  ".rangeValuePreparation"
) as HTMLBodyElement;
const rangeValueCooking = document.querySelector(
  ".rangeValueCooking"
) as HTMLBodyElement;
const nameInput = document.getElementById("nameInput") as HTMLInputElement;
const IngredientSelect = document.getElementById("IngredientSelect") as HTMLSelectElement;

const recipeList: IRecipe[] = [];

function getRecipe():void {
  for (const key in recipeData) {
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

  displayRecipe();
  displayIngredientsInSelect();
}
function createRecipeElement(recipe: IRecipe):void {
  recipeContent.innerHTML += `
    <div class="mb-3 w-100 rounded recipe" id="${recipe.id}">
      <h3 class="fw-bold text-center pt-2">${recipe.name}</h3>
      <hr>
      <div class="d-flex justify-content-around">
        <div class="d-flex">
          <i class="bi bi-gear"></i>
          <p>${recipe.prepTime}</p>
        </div>
        <div class="d-flex">
          <i bi bi-fire pr-2"></i>
          <p>${recipe.cookTime}</p>
        </div>
      </div>
    </div>
  `;
}
function displayRecipe():void {
  recipeList.forEach((recipe) => {
    createRecipeElement(recipe);
  });
  displayModal();
}

function displayModal():void {
  const recipeItems : NodeListOf<Element>  = document.querySelectorAll(".recipe");
  recipeItems.forEach((element:Element) => {
    element.addEventListener("click", () => {
      const id: string = element.id;
      createModal(id);
      modal.style.display = "block";
    });
  });
}

function createModal(id: string):void {
  const recipe : IRecipe|undefined = recipeList.find((r) => r.id === id);

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

function closeModal():void {
  const btnModalClose: Element|null = document.querySelector(".close");
  if (btnModalClose) {
    btnModalClose.addEventListener("click", () => {
      modal.style.display = "none";
    });
  }
}

function displayIngredientsInSelect():void {
  const uniqueIngredients:Set<string> = new Set<string>();

  recipeList.forEach((recipe) => {
    recipe.ingredients.forEach((ingredient) => {
      uniqueIngredients.add(ingredient.name);
    });
  });

  const selectElement = document.getElementById(
    "IngredientSelect"
  ) as HTMLBodyElement;

  uniqueIngredients.forEach((ingredientName) => {
    const option:HTMLOptionElement = document.createElement("option");
    option.text = ingredientName;
    selectElement.appendChild(option);
  });
}

function filter() {
  const searchTerm:string = nameInput.value.toLowerCase();
  const minPrepTime:number = +inputRangePreparation.value;
  const minCookTime:number = +inputRangeCooking.value;

  const selectedIngredients:string[] = Array.from(IngredientSelect.selectedOptions).map(option => option.text.toLowerCase());

  // Filtrer les recettes par nom
  let filteredRecipes: IRecipe[] = recipeList.filter((recipe) => {
    const recipeName:string = recipe.name.toLowerCase();
    return recipeName.includes(searchTerm);
  });

  // Filtrer les recettes par temps de préparation
  if (!isNaN(minPrepTime)) {
    filteredRecipes = filteredRecipes.filter((recipe) => {
      const prepTime:number = +recipe.prepTime.split(" ")[0];
      return prepTime <= minPrepTime;
    });
  }

  // Filtrer les recettes par temps de cuisson
  if (!isNaN(minCookTime)) {
    filteredRecipes = filteredRecipes.filter((recipe) => {
      const cookTime:number = +recipe.cookTime.split(" ")[0];
      return cookTime <= minCookTime;
    });
  }

  // Filtrer les recettes par ingrédients sélectionnés
  if (selectedIngredients.length > 0) {
    filteredRecipes = filteredRecipes.filter((recipe) => {
      const recipeIngredients:string[] = recipe.ingredients.map(ingredient => ingredient.name);
      const hasAllSelectedIngredients:boolean = selectedIngredients.every(selectedIngredient =>
        recipeIngredients.includes(selectedIngredient)
      );
      return hasAllSelectedIngredients;
    });
  }

  recipeContent.innerHTML = "";

  filteredRecipes.forEach((recipe) => {
    createRecipeElement(recipe);
  });

  displayModal();
}

window.addEventListener("load", getRecipe);

inputRangePreparation.addEventListener("input", () => {
  filter();
  rangeValuePreparation.textContent = `Preparation time : ${inputRangePreparation.value} min`;
});

inputRangeCooking.addEventListener("input", () => {
  filter();
  rangeValueCooking.textContent = `Cooking time : ${inputRangeCooking.value} min`;
});

nameInput.addEventListener("input", filter);

IngredientSelect.addEventListener("change", filter);

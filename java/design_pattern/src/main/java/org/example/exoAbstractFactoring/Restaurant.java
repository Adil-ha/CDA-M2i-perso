package org.example.exoAbstractFactoring;

public class Restaurant{

    private Ingredient ingredient;
    private CookingUstensil cookingUstensil;
    private Dish dish;

    private CuisineFactory cuisineFactory;

    public Restaurant(CuisineFactory cuisineFactory){
        setCuisineFactory(cuisineFactory);
    }

    public void setCuisineFactory(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
        ingredient = this.cuisineFactory.createIngredient();
        dish = this.cuisineFactory.createDish();
        cookingUstensil = this.cuisineFactory.createUstensil();
    }

    public void runPlate() {
        ingredient.prepare();
        cookingUstensil.use();
        dish.serve();
    }

}

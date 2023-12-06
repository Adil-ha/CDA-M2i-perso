package org.example.exoAbstractFactoring;

public abstract class CuisineFactory {
    abstract Ingredient createIngredient();

    abstract CookingUstensil createUstensil();

    abstract Dish createDish();
}

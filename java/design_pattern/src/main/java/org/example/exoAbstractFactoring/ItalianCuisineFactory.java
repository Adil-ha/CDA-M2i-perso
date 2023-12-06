package org.example.exoAbstractFactoring;

public class ItalianCuisineFactory extends CuisineFactory{
    @Override
    Ingredient createIngredient() {
        return new ItalianIngredient();
    }
    @Override
    CookingUstensil createUstensil() {
        return new ItalianUstensil();
    }

    @Override
    Dish createDish() {
        return new ItalianDish();
    }
}

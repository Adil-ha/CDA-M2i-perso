package org.example.exoAbstractFactoring;

public class MexicanCuisineFactory extends CuisineFactory{
    @Override
    Ingredient createIngredient() {
        return new MexicanIngredient();
    }

    @Override
    CookingUstensil createUstensil() {
        return new MexicanUstensil();
    }

    @Override
    Dish createDish() {
        return new MexicanDish();
    }
}

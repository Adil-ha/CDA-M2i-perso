package org.example.exoAbstractFactoring;

public class JapaneseCuisineFactory extends CuisineFactory{
    @Override
    Ingredient createIngredient() {
        return new JapaneseIngredient();
    }

    @Override
    CookingUstensil createUstensil() {
        return new JapaneseUstensil();
    }

    @Override
    Dish createDish() {
        return new JapaneseDish();
    }
}

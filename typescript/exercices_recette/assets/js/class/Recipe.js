"use strict";
// import { IRecipe } from "../Interface/IRecipe";
// export class Recipe implements IRecipe {
//     private _id?: string;
//     private _name: string;
//     private _servings: number;
//     private _prepTime: string;
//     private _cookTime: string;
//     private _ingredients: {
//       name: string;
//       amount: string;
//     }[];
//     private _instructions: string[];
//     constructor(
//       name: string,
//       servings: number,
//       prepTime: string,
//       cookTime: string,
//       ingredients: { name: string; amount: string }[],
//       instructions: string[],
//       id?: string
//     ) {
//       this._id = id;
//       this._name = name;
//       this._servings = servings;
//       this._prepTime = prepTime;
//       this._cookTime = cookTime;
//       this._ingredients = ingredients;
//       this._instructions = instructions;
//     }
//     get id(): string | undefined {
//       return this._id;
//     }
//     set id(value: string | undefined) {
//       this._id = value;
//     }
//     get name(): string {
//       return this._name;
//     }
//     set name(value: string) {
//       this._name = value;
//     }
//     get servings(): number {
//       return this._servings;
//     }
//     set servings(value: number) {
//       this._servings = value;
//     }
//     get prepTime(): string {
//       return this._prepTime;
//     }
//     set prepTime(value: string) {
//       this._prepTime = value;
//     }
//     get cookTime(): string {
//       return this._cookTime;
//     }
//     set cookTime(value: string) {
//       this._cookTime = value;
//     }
//     get ingredients(): { name: string; amount: string }[] {
//       return this._ingredients;
//     }
//     set ingredients(value: { name: string; amount: string }[]) {
//       this._ingredients = value;
//     }
//     get instructions(): string[] {
//       return this._instructions;
//     }
//     set instructions(value: string[]) {
//       this._instructions = value;
//     }
//   }

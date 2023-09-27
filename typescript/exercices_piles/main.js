"use strict";
class Pile {
    constructor(tabPile) {
        this.tabPile = tabPile;
    }
    empiler(element) {
        this.tabPile.push(element);
        return this.tabPile;
    }
    depiler() {
        this.tabPile.pop();
        return this.tabPile;
    }
    getTabPile() {
        return this.tabPile;
    }
}
const maPile = new Pile([1, 2, 3]);
maPile.empiler(4);
console.log(maPile);
const elementDepile = maPile.depiler();
console.log(elementDepile);
const maPileDeString = new Pile(["aa", "bb", "cc"]);
maPileDeString.empiler("gg");
console.log(maPileDeString);
maPileDeString.depiler();
console.log(maPileDeString);

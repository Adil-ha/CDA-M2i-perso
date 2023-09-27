class Pile<T> {
  private tabPile: T[];

  constructor(tabPile: T[]) {
    this.tabPile = tabPile;
  }

  public empiler(element: T): T[] {
    this.tabPile.push(element);
    return this.tabPile;
  }

  public depiler(): T[] {
    this.tabPile.pop();
    return this.tabPile;
  }

  public getTabPile(): T[] {
    return this.tabPile;
  }
}

const maPile = new Pile<number>([1, 2, 3]);
maPile.empiler(4);
console.log(maPile);
const elementDepile = maPile.depiler();
console.log(elementDepile);

const maPileDeString = new Pile<string>(["aa", "bb", "cc"]);
maPileDeString.empiler("gg");
console.log(maPileDeString);
maPileDeString.depiler();
console.log(maPileDeString);

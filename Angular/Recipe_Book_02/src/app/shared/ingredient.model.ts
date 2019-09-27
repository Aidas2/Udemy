// classic version:
// export class Ingredient {
//   public name: string;
//   public amount: number;

//   constructor(name: string, amount: number) {
//   this.name = name;
//   this.amount = amount;
//   }
// }

// new version:
export class Ingredient {
  constructor(public name: string, public amount: number) {}
}

export class Product {
  private _price: number = -1;
  private _name: string = "";
  constructor(name: string, price: number) {
    this._price = price;
    this._name = name;
  }

  get price(): number {
    return this._price;
  }
  set price(_price: number) {
    this._price = _price;
  }

  get name(): string {
    return this._name;
  }
  set name(name: string) {
    this._name = name;
  }

}

class Product {
  constructor(id, name) {
    this.id = id;
    this.name = name;
  }
}
class Phone extends Product {
  constructor(id, name, os) {
    super(id, name);
    this.os = os;
  }
  getOperatingSystem() {
    return this.os;
  }

  display() {
    console.log("os=" + this.os + "-" + super.id + "-" + super.name);
  }
}
const product = new Phone(1, "galaxy", "android");
product.display();
const os = product.getOperatingSystem();
console.log("operating system=" + os);

var Product = /** @class */ (function () {
    function Product(name, price) {
        this.name = name;
        this.price = price;
    }
    Product.prototype.display = function () {
        console.log(this.name + "," + this.price);
    };
    return Product;
}());
var product = new Product("samsung", 20000);
product.display();

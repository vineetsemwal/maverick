var i=10;
i="hello";
console.log("i="+i);

var user1={name:"mani", age:25};
user1.city="bangalore";

function add(num1, num2){
    var result=num1+num2;
    return result;
}

function User(name,age){
    this.name=name;
    this.age=age;
}
var user2=new User("sunit",23);
console.log(user2);
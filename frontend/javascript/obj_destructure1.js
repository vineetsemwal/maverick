/*
object destructuring
*/
let user={name:"shanta", age:24};

//let name=user.name;
//let age=user.age;
let {name,age}=user;
let {name:name1,age:age1}=user;
console.log("name age",name+","+age);
console.log("name age",name1+","+age1);

let fruits=["apple", "mango"];
let[fruit1,fruit2]=fruits;
console.log("fruit1="+fruit1);
console.log("fruit2="+fruit2);
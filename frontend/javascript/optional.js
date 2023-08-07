
function getUser(){
   // let user={uname:"mani", age:21};
   let user;
    return user;
}

let user=getUser();
//if user is null or undefined, shortcircuit ie. don't evaluate further return undefined

let uname=user?.uname;
console.log("name is "+uname);

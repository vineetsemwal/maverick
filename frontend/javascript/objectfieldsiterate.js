var user={name:"laxman", age:21};
user.salary=undefined;
for(var field in user){
    var value= user[field];
    console.log("field="+field+" ,value="+value);
 }

/*
finds undefined fields of any object
*/
function fetchAllUndefinedFields(objArg){
 var desiredFields=[];
    for(var field in objArg){
    var value=objArg[field];
    if(!value){
        desiredFields.push(field);
    }
}
return desiredFields;
}
var userUndefinedFields=fetchAllUndefinedFields(user);
var product={name:"samsung", price:20000};
product.category=undefined;
for(var iterated of userUndefinedFields){
 console.log("undefined field in user ="+iterated);
}

var productUndefinedFields=fetchAllUndefinedFields(product);
for(var iterated of productUndefinedFields){
    console.log("undefined fields of product="+iterated);
}


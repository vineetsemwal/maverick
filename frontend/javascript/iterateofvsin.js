var fruits=["apple","mango","banana"];
for(var index in fruits){
var iteratedValue=fruits[index];
console.log(iteratedValue+" on index="+index);
}

for(var iteratedValue of fruits){
console.log(iteratedValue);
}
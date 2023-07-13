function add(num1, num2){
    return num1+num2;
}

function addUsed(funAsArg, num1, num2){
  const result=funAsArg(num1,num2);
  return result;
}
const result=addUsed(add,1,2);
console.log("result="+result);
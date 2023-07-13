function add(...args){
 let result=0;
 for(let iterated of args){
    result=result+iterated;
 }
 return result;
}
const result1=add(1);
const result2=add(1,2);
const result3=add(1,2,3,4);
console.log("result1="+result1);
console.log("result2="+result2);
console.log("result3="+result3);




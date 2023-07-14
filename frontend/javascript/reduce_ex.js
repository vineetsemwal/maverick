let array=[1,2,3,4];

const result=array.reduce( (accumulator,e)=>{
    return accumulator+e;
} );

console.log("result="+result);

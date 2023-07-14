async function isEven(num) {
      const result = num % 2 == 0;
      console.log("inside is even =" + result);  
      return result;   
    }
  
async  function useIsEven() {
    try{
    const result=await isEven(10);
    console.log("result="+result);
    }catch(err){
        console.log("error is "+err);
    }
  }
  useIsEven();
  
function isEven(num) {
    const executor = (resolve, reject) => {
      if (!num) {
        reject("number is invalid");
        return;
      }
      const result = num % 2 == 0;
      resolve(result);
      console.log("inside is even =" + result);
    };
  
    const promise = new Promise(executor);
    return promise;
  }
  
async   function useIsEven() {
    const result=await isEven(10);
    console.log("result="+result);
  }
  useIsEven();
  
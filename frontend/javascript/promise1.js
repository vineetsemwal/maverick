/**
 * 
 * @param {*} num 
 * @returns Promise
 */
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

function useIsEven() {
  const promise = isEven();
  console.log("after method call");
  const successHandlerCallback = (result) => {
    console.log("number even=" + result);
  };
  const errCallback = (err) => {
    console.log("error received", err);
  };
  promise.then(successHandlerCallback)
  .catch(errCallback);
  console.log("after adding handlers");
}
useIsEven();

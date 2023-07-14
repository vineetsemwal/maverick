async function isEven(num) {
  if (!num) {
    throw new Error("num is invalid");
  }
  const result = num % 2 == 0;
  console.log("inside is even =" + result);
  return result;
}

async function useIsEven() {
  try {
    const result = await isEven();
    console.log("result=" + result);
  } catch (err) {
    console.log("error is " + err);
  }
}
useIsEven();

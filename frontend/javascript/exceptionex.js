function add(num1, num2) {
  if (!num1 || !num2) {
    throw new Error("num1 is undefined");
  }
  return num1+num2;

}

function addUserClient() {
  try {
    var result = add(1);
    console.log("result=" + result);
  } catch (err) {
    console.log("exception caught=",err);
    
  }
}

addUserClient();
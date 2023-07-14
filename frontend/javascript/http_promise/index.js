const axios=require("axios");
const baseUrl="http://localhost:3000/employees";
async function fetchEmployeeById(id){
 try{
    const url=baseUrl+"/"+id;
    console.log("url="+url);
    let response=await axios.get(url);
    let data=await response.data;
    console.log("response=",data);
    console.log("fetched result="+data);
 }catch(err){
console.log("err is "+err);
 }
}

fetchEmployeeById(1);
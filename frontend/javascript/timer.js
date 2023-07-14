let id;
function calculateDateTime(){
 id=setInterval(()=>{
    const date=new Date();
    console.log("date="+date);      
    },10000);
}
calculateDateTime();
//clearInterval(id);
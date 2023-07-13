var user={
username:"mohan",
age:21,
reInitialize:function(name,age){
this.username=name;
this.age=age;
},
display: function(){
    console.log(this.username+","+this.age);
}
};
user.display();
user.reInitialize("laxman",25);
user.display();
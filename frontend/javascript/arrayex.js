var fruits=["apple","mango"];
fruits.push("banana","grapes");
fruits[10]="pinapple";

for(var i=0;i <fruits.length;i++){
    var iterated=fruits[i];
    console.log("iterated="+iterated);
}
package genericdemo;

public class Store<Type> {
       private Type element;

       public void add(Type element){
           this.element=element;
       }

       public  Type getElement(){
           return element;
       }

}

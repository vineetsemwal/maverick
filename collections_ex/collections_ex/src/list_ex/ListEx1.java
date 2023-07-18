package list_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListEx1 {

    public static void main(String[] args) {
        List<Integer>list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // fetch by index
       Integer elementIndex1=list.get(1);
       // add element at index-0
        list.add(0,20);

        //overwriting element at index 2
        list.set(2,50);

        Iterator<Integer>iterator=list.iterator();
        while (iterator.hasNext()){
            int iterated=iterator.next();
            if(iterated%2==0){
                iterator.remove();
            }
        }
        System.out.println(list);




    }
}

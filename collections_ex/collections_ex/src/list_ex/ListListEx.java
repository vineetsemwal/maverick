package list_ex;

import java.util.Deque;
import java.util.LinkedList;

public class ListListEx {

    public static void main(String[] args) {
        Deque<Integer>queue=new LinkedList<>();
        queue.add(10);
        // add versions throw IllegalStateException in case of capacity restricted queue
        //if there is not more space
        queue.addFirst(5);
        queue.addLast(15);
        //offer versions don't throw exception in case of capacity restricted queues
        queue.offerLast(40);
        queue.offerFirst(20);
        System.out.println("queue at start="+queue);

        //peek versions don't throw any exception and element is not taken off queue
        int e1=queue.peek();
        System.out.println("after peek e1="+e1);

        // same as peek
        int e2=queue.peekFirst();
        System.out.println("after peek first e2="+e2);

        //fetch from tail/end
        int e3=queue.peekLast();
        System.out.println("after peeklast e3="+e3);

        //get versions throws exception if queue is empty else works like peek version
        int e4=queue.getFirst();
        System.out.println("after getfirst e4="+e4);

        //fetches first element and element is taken off from queue
        int e5=queue.poll();
        System.out.println("after poll e5="+e5);
        System.out.println("queue after poll"+queue);
    }
}

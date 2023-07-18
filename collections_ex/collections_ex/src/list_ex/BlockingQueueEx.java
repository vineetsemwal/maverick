package list_ex;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueEx {
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayBlockingQueue<>(1);
        // add versions throw IllegalStateException in case of capacity restricted queue
        //if there is not more space
        queue.add(10);
        System.out.println("queue after add first element "+queue);
        //offer versions don't throw exception in case of capacity restricted queues
        boolean result=queue.offer(40);
        System.out.println("result of adding second eement ="+result);
        System.out.println("queue at start="+queue);

        Integer polled1=queue.poll();
        Integer polleded2=queue.poll();
        System.out.println("polled1="+polled1);
        System.out.println("polled 2="+polleded2);

    }
}

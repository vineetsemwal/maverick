package genericdemo;

public class StoreUsage {
    public static void main(String[] args) {
        Store<Integer> store=new Store();
        store.add(8);
        Object obj=store.getElement();
        int val=store.getElement();

    }
}

package list_ex;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx1 {

    public static void main(String[] args) {
        Comparator<Product>comparator=(product1,product2)->product1.price-product2.price;
        NavigableSet<Product>products=new TreeSet<>(comparator);
        products.add(new Product("samsung",30000));
        products.add(new Product("samsung",20000));
        products.add(new Product("moto",15000));
        products.add(new Product("iphone",70000));

        Product higher=products.higher(new Product("moto",15000));
        System.out.println("higher="+higher);
        Product lower=products.lower(new Product("samsung",30000));
        System.out.println("lowe="+lower);

        Product firstElement=products.first();
        Product lastElement=products.last();
        System.out.println("first element="+firstElement);
        System.out.println("last element="+lastElement);
        Set<Product> subset= products.subSet(new Product("samsung",20000),
                new Product("iphone",70000));
        System.out.println("subset="+subset);


    }

    private static class Product implements Comparable<Product>{
        String name;
        int price;
        public Product(String name, int price){
            this.name=name;
            this.price=price;
        }

        @Override
        public int compareTo(Product e) {
            return this.price-e.price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}

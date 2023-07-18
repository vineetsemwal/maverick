package list_ex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingEx {
    public static void main(String[] args) {
        List<Product>list=new ArrayList<>();
        list.add(new Product("samsung",30000));
        list.add(new Product("samsung",20000));
        list.add(new Product("moto",15000));
        list.add(new Product("iphone",70000));
        Comparator<Product>ascByNameAndPrice=(product1,product2)-> {
            boolean equals=product1.name.equals(product2.name);
            if(!equals){
                return product1.name.compareTo(product2.name);
            }
            return product1.price-product2.price;
        };
        list.sort(ascByNameAndPrice);
        System.out.println("list asc order by price="+list);
        Comparator<Product>descByPrice=(product1,product2)->product2.price-product1.price;
        list.sort(descByPrice);
        System.out.println("list desc order by price="+list);

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

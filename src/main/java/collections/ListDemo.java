package collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(null);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("list1 = " + list1);

        // operation on list
        System.out.println("list1.indexOf(0) = " + list1.indexOf(0));
        System.out.println("list1.indexOf(1) = " + list1.indexOf(1));
        System.out.println("list1.indexOf(null) = " + list1.indexOf(null));
        System.out.println("list1.lastIndexOf(1) = " + list1.lastIndexOf(1));
        System.out.println("list1.lastIndexOf(2) = " + list1.lastIndexOf(2));
        list1.remove(list1.lastIndexOf(1));
        list1.set(2, 10);
        System.out.println("list1 = " + list1);

        // Bulk operations on list
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(30);
        list2.add(10);
        list1.removeAll(list2);
        System.out.println("list1 = " + list1);
        list1.addAll(list2);
        list1.set(1, 20);
        list1.add(0,  50);
        System.out.println("list1 = " + list1);

        // Range operation
        List<Integer> list3 = list1.subList(1, 4);
        list3.add(10);
        System.out.println("list3 = " + list3);

        // iterate list
    }
}

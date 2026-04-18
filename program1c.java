import java.util.*;

public class LinkedListAllInOne {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        // Adding elements
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("Initial List: " + list);

        // 1. Iterate from 2nd position
        System.out.println("\n1. Iterate from 2nd position:");
        Iterator<String> it1 = list.listIterator(1);
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        // 2. Reverse iteration
        System.out.println("\n2. Reverse iteration:");
        Iterator<String> it2 = list.descendingIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        // 3. Insert at end
        System.out.println("\n3. Insert at end:");
        list.offerLast("Pink");
        System.out.println("After insertion: " + list);

        // 4. Display elements with position
        System.out.println("\n4. Elements with positions:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Position " + i + ": " + list.get(i));
        }

        // 5. Swap first and third elements
        System.out.println("\n5. Swap first and third:");
        if (list.size() >= 3) {
            Collections.swap(list, 0, 2);
        }
        System.out.println("After swapping: " + list);
    }
}
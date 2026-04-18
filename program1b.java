package program1b;
import java.util.*;

public class ArrayListAllInOne {
    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();

        // Adding elements
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");
        colors.add("Yellow");

        System.out.println("Initial Colors: " + colors);

        // 1. Check if "Red" is present
        System.out.println("\n1. Checking 'Red':");
        if (colors.contains("Red")) {
            System.out.println("Red is available");
        } else {
            System.out.println("Red is not available");
        }

        // 2. Remove 2nd element and "Blue"
        System.out.println("\n2. Removing 2nd element and 'Blue':");
        colors.remove(1);      // remove 2nd element
        colors.remove("Blue"); // remove by object
        System.out.println("After removal: " + colors);

        // 3. Sorting
        System.out.println("\n3. Sorting:");
        Collections.sort(colors);
        System.out.println("Sorted: " + colors);

        // 4. Extract sublist (1st & 2nd)
        System.out.println("\n4. SubList (0-2):");
        List<String> subList = colors.subList(0, Math.min(2, colors.size()));
        System.out.println(subList);

        // 5. Delete nth element
        System.out.println("\n5. Delete nth element:");
        if (colors.size() > 2) {
            colors.remove(2); // deleting 3rd element
        }
        System.out.println("After deleting index 2: " + colors);
    }
}
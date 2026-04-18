// Java Program to demonstrate performance of StringBuffer and StringBuilder
public class PerformanceTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // StringBuffer (thread-safe, slower)
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            sb.append("Tpoint");
        }

        System.out.println("Time taken by StringBuffer: " + 
                (System.currentTimeMillis() - startTime) + " ms");

        // Reset timer
        startTime = System.currentTimeMillis();

        // StringBuilder (faster, not thread-safe)
        StringBuilder sb2 = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++) {
            sb2.append("Tpoint");
        }

        System.out.println("Time taken by StringBuilder: " + 
                (System.currentTimeMillis() - startTime) + " ms");
    }
}
import java.util.HashSet;
import java.util.Set;

public class Answer {
    public static int next(int n) {
        Set<Character> digits = new HashSet<>();
        String nStr = Integer.toString(n);

        // Add all digits of n to the set
        for (char c : nStr.toCharArray()) {
            digits.add(c);
        }

        // Start looking for the next number with unique digits
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (!hasCommonDigits(i, digits)) {
                return i;
            }
        }

        // If no such number is found, return -1
        return -1;
    }

    private static boolean hasCommonDigits(int num, Set<Character> digits) {
        String numStr = Integer.toString(num);
        for (char c : numStr.toCharArray()) {
            if (digits.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Testing different inputs as specified
        System.out.println(next(2));       // Should print 3
        System.out.println(next(901));     // Should print 2222
        System.out.println(next(958));     // Should print 1000
        System.out.println(next(3025));    // Should print 4111
        System.out.println(next(654321));  // Should print 700000
    }
}

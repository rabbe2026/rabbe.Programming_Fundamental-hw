import java.util.Locale;
import java.util.Scanner;

public class Task2 {

    // Whole numbers without decimals, others with up to 2 decimals.
    static String fmt(double x) {
        String s = String.format(Locale.US, "%.2f", x);
        if (s.contains(".")) {
            s = s.replaceAll("0+$", "").replaceAll("\\.$", "");
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] residents = new int[n];
        for (int i = 0; i < n; i++) {
            residents[i] = sc.nextInt();
        }

        int total = 0, leftSum = 0, rightSum = 0;
        int leftCount = 0, rightCount = 0;

        for (int i = 0; i < n; i++) {
            int houseNumber = i + 1;
            total += residents[i];
            if (houseNumber % 2 == 1) {       // odd -> left side
                leftSum += residents[i];
                leftCount++;
            } else {                           // even -> right side
                rightSum += residents[i];
                rightCount++;
            }
        }

        String leftAvg = leftCount > 0 ? fmt((double) leftSum / leftCount) : "N/A";
        String rightAvg = rightCount > 0 ? fmt((double) rightSum / rightCount) : "N/A";

        System.out.println("Total residents: " + total);
        System.out.println("Residents on the left: " + leftSum);
        System.out.println("Residents on the right: " + rightSum);
        System.out.println("Average per house on the left: " + leftAvg);
        System.out.println("Average per house on the right: " + rightAvg);
    }
}

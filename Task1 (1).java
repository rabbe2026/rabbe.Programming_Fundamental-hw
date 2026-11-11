import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        String[] text = new String[n];
        double[] radii = new double[n];
        for (int i = 0; i < n; i++) {
            text[i] = sc.next();
            radii[i] = Double.parseDouble(text[i]);
        }

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (radii[i] > radii[maxIndex]) {
                maxIndex = i;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (radii[i] == radii[maxIndex]) {
                count++;
            }
        }

        // print the radius the way it was written in the input
        System.out.println(text[maxIndex] + " - " + count);
    }
}

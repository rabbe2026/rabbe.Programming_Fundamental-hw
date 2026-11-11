import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Task3 {

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
        int subjects = sc.nextInt();
        int students = sc.nextInt();

        double[][] grades = new double[students][subjects];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                grades[i][j] = sc.nextDouble();
            }
        }

        double[] averages = new double[students];
        double averagesSum = 0;
        for (int i = 0; i < students; i++) {
            double sum = 0;
            for (int j = 0; j < subjects; j++) {
                sum += grades[i][j];
            }
            averages[i] = sum / subjects;
            averagesSum += averages[i];
        }
        double groupAverage = averagesSum / students;

        double best = averages[0];
        for (int i = 1; i < students; i++) {
            if (averages[i] > best) {
                best = averages[i];
            }
        }

        List<Integer> bestStudents = new ArrayList<>();
        List<Integer> lowStudents = new ArrayList<>();
        for (int i = 0; i < students; i++) {
            if (Math.abs(averages[i] - best) < 1e-9) {
                bestStudents.add(i + 1);
            }
            for (int j = 0; j < subjects; j++) {
                if (grades[i][j] < 5) {
                    lowStudents.add(i + 1);
                    break;
                }
            }
        }

        System.out.println("Student averages:");
        for (int i = 0; i < students; i++) {
            System.out.println(fmt(averages[i]));
        }
        System.out.println();
        System.out.println("Group average:");
        System.out.println(fmt(groupAverage));
        System.out.println();
        System.out.println("Highest-performing student:");
        System.out.println(join(bestStudents));
        System.out.println();
        System.out.println("Students with at least one grade below 5:");
        System.out.println(lowStudents.isEmpty() ? "None" : join(lowStudents));
    }

    static String join(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}

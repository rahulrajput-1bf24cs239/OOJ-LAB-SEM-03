import CIE.*;
import SEE.*;
import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Internals internal[] = new Internals[n];
        External external[] = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int cieMarks[] = new int[5];
            System.out.println("Enter 5 Internal Marks:");
            for (int j = 0; j < 5; j++) {
                cieMarks[j] = sc.nextInt();
            }

            int seeMarks[] = new int[5];
            System.out.println("Enter 5 SEE Marks:");
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }

            internal[i] = new Internals(cieMarks);
            external[i] = new External(usn, name, sem, seeMarks);
        }

        // Display Final Marks
        System.out.println("\n===== FINAL MARKS OF ALL STUDENTS =====");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + external[i].name);
            System.out.println("USN: " + external[i].usn);
            System.out.println("Semester: " + external[i].sem);

            System.out.println("Course\tCIE\tSEE\tFinal");

            for (int j = 0; j < 5; j++) {
                int finalMarks = internal[i].internalMarks[j] + (external[i].seeMarks[j] / 2);
                // SEE marks are out of 100, only 50 are counted.
                System.out.println((j + 1) + "\t" +
                    internal[i].internalMarks[j] + "\t" +
                    external[i].seeMarks[j] + "\t" + finalMarks);
            }
        }

        sc.close();
    }
}

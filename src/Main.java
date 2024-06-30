import java.util.Arrays;
import java.util.Comparator;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        System.out.println("Students with names starting from 'H':");
        studentRepository.printStudentsWithNameStartingFrom("Haris");

        System.out.println("\nAll students:");
        studentRepository.printAllStudents();


        System.out.println("\nFirst student in List:");
        studentRepository.FirstStudent();

        System.out.println("\nPrevious Student in List before Huraira");
        studentRepository.PreviousStudent("Huraira");

        
        }
    }





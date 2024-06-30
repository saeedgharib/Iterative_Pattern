import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class StudentRepository implements Container {
    public Student[] students;

    public StudentRepository() {
        students = new Student[]{
                new Student("054", "Basit Malik", "Male", "00000000000"),
                new Student("071", "Muhammad Saeed", "Male", "00000000000"),
                new Student("066", "Haris Khan", "Male", "00000000000"),
                new Student("082", "Haris Naeem", "Male", "00000000000"),
                new Student("045", "Huraira", "Male", "00000000000")
        };
    }

    @Override
    public Iterator getIterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < students.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return students[index++];
            }
            return null;
        }

        public boolean hasPrevious() {
            if (index > 0) {
                return true;
            }
            return false;
        }

        public Object previous() {
            if (this.hasPrevious()) {
                return students[--index];
            }
            return null;
        }

        public void moveToLast() {
            index = students.length - 1;
        }

        public void moveToFirst() {
            index = 0;
        }
    }

    public void printStudentsWithNameStartingFrom(String startingValue) {
        StudentIterator iterator = (StudentIterator) getIterator();
        iterator.moveToLast();
        while (iterator.hasPrevious()) {
            Student student = (Student) iterator.previous();
            assert student != null;
            if (student.getName().startsWith(startingValue)) {
                System.out.println(student);
            }
        }
    }

    public void FirstStudent() {
        Arrays.sort(students, Comparator.comparing(Student::getName));

        StudentIterator iterator = (StudentIterator) getIterator();
        iterator.moveToFirst();
        System.out.println(students[iterator.index]);
    }
    public void PreviousStudent(String name) {

        StudentIterator iterator = (StudentIterator) getIterator();
        for (int i = 0; i < students.length; i++) {
           if (Objects.equals(students[i].getName(), name)){
               iterator.index=i;
               System.out.println(iterator.previous());
           }
        }
    }
    public void printAllStudents() {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        StudentIterator iterator = (StudentIterator) getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
    //  sorting by rollNo using this
    // public int compareTo(Student s){
    //     return this.rollNo - s.rollNo;
    // }
    public int compareTo(Student s){
        return this.name.compareTo(s.name);
    }
}

class Teacher implements Comparable<Teacher> {
    String name;
    int IDNo;

    Teacher(String name, int IDNo){
        this.name = name;
        this.IDNo = IDNo;
    }

    //  sorting by IDNo using this
    public int compareTo(Teacher t){
        return this.IDNo - t.IDNo;
    }
}

public class J04_CustomComparator {
    public static void main(String[] args) {

        Student[] arr = {
            new Student("Isha", 3),
            new Student("Aman", 1),
            new Student("Riya", 2)
        };

        Teacher[] t = {
            new Teacher("Isha", 3),
            new Teacher("Aman", 1),
            new Teacher("Riya", 2)
        };

        // 🔹 Before sorting
        System.out.println("Students Before:");
        for(Student s : arr){
            System.out.println(s.name + " " + s.rollNo);
        }

        // 🔹 Sort (uses compareTo internally)
        Arrays.sort(arr);

        System.out.println("\nStudents After Sorting by RollNo:");
        for(Student s : arr){
            System.out.println(s.name + " " + s.rollNo);
        }

        // 🔹 Teacher sorting
        Arrays.sort(t);

        System.out.println("\nTeachers After Sorting by ID:");
        for(Teacher x : t){
            System.out.println(x.name + " " + x.IDNo);
        }
    }
}
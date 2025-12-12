import java.util.*;

class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getRole() {
        return "Undergrad";
    }

    public void getReport(String id) {
        System.out.println("\n\nGenerating report for Student ID: " + id);
        System.out.println("...............................");
        System.out.println("Name: " + name);
        System.out.println("Role: " + getRole());
        System.out.println("Marks: " + marks);
        System.out.println("...............................");
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }

}

class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole() {
        return "Graduate";
    }
}

class Teacher {
    private String id, name, subject;

    public Teacher(String id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Subject: " + subject;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }
    
}

class Repository<T> {
    private Map<String, T> data = new HashMap<>();

    public void add(String id, T item) {
        data.put(id, item);
    }

    public T get(String id) {
        return data.get(id);
    }

    public void delete(String id) {
        data.remove(id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S1", "Akshay", 85));
        students.add(new Student("S2", "Prateek", 95));
        students.add(new GraduateStudent("S3", "Driti", 90, "Computer Science"));
        students.add(new GraduateStudent("S4", "Ananya", 88, "BBA"));
        students.add(new Student("S5", "Rohan", 92));
        students.add(new Student("S6", "Simran", 78));

        Repository<Student> studentRepo = new Repository<>();
        for (Student s : students) {
            studentRepo.add(s.getId(), s);
        }

        System.out.println("All Students:");
        students.forEach(System.out::println);

        System.out.println("\nRetrieve Student with ID S2:");
        System.out.println(studentRepo.get("S2"));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getMarks() < 90) {
                iterator.remove();
                studentRepo.delete(s.getId());
            }
        }

        System.out.println("\nStudents after removing those with marks < 90:");
        students.forEach(System.out::println);


        Repository<Teacher> teacherRepo = new Repository<>();
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("T1", "Mr. Sharma", "Fullstack"));
        teachers.add(new Teacher("T2", "Ms. Gupta", "Data Science"));
        teachers.add(new Teacher("T3", "Dr. Verma", "Cybersecurity"));
        teachers.add(new Teacher("T4", "Prof. Iyer", "AI"));
        teachers.add(new Teacher("T5", "Mrs. Singh", "Cloud Computing"));
        for (Teacher t : teachers) {
            teacherRepo.add(t.getId(), t);
        }

        
        System.out.println("\nAll Teachers:");
        teachers.forEach(System.out::println);

        System.out.println("\nRetrieve Teacher with ID T1:");
        System.out.println(teacherRepo.get("T1"));


        Iterator<Teacher> teacherIterator = teachers.iterator();
        while (teacherIterator.hasNext()) {
            Teacher t = teacherIterator.next();
            if (t.getSubject().equals("Fullstack")) {
                teacherIterator.remove();
                teacherRepo.delete(t.getId());
            }
        }
        
        for (Student s : students) {
            s.getReport(s.getId());
        }
    }
}

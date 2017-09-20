import java.util.Comparator;
import java.util.TreeSet;

public class Students {


    public static void main(String[] args) {
        System.out.println("Пример сортировки по возрасту:");
        TreeSet<Student> stud2 = new TreeSet<>(new MyCompare());
        stud2.add(new Student("Иван", 19, 200));
        stud2.add(new Student("Олег", 18, 100));
        stud2.add(new Student("Павел", 17, 90));
        stud2.add(new Student("Сергей", 20, 300));

        for (Student st : stud2) {

            System.out.println(st.name+" "+st.age+" "+st.stip);
        }
        System.out.println("Пример сортировки по стипендии:");
        TreeSet<Student> stud = new TreeSet<>();
        stud.add(new Student("Иван", 19, 200));
        stud.add(new Student("Олег", 18, 300));
        stud.add(new Student("Павел", 17, 90));
        stud.add(new Student("Сергей", 20, 400));

        for (Student st : stud) {

            System.out.println(st.name+" "+st.age+" "+st.stip);
        }

    }
}

class MyCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age < o2.age) {
            return -1;
        } else if (o1.age > o2.age) {
            return 1;
        }
        return 0;
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    public int stip;

    public Student(String name, int age, int stip) {
        this.name = name;
        this.age = age;
        this.stip = stip;
    }

    @Override
    public int compareTo(Student st) {
        if (this.stip < st.stip) {
            return -1;
        } else if (this.stip > st.stip) {
            return 1;
        }
        return 0;
    }

}
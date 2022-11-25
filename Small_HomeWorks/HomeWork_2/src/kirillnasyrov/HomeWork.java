package kirillnasyrov;

import java.util.HashMap;

public class HomeWork {
    public HashMap<Person, Integer> students;

    public HomeWork(Person[] array) {
        students = new HashMap<>();
        int i;
        for (i = 0; i < array.length; ++i) {
            students.put(array[i], null);
        }
    }

    public void print() {
        for (Person student : students.keySet()) {
            System.out.println(student.getInformation() + ": " + students.get(student));
        }
        System.out.println();
    }
}

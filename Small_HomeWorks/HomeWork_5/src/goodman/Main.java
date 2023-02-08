package goodman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Kirill", "Nasyrov", 9, "Russia"));
        userList.add(new User(1, "Kirill", "Nasyrov", 20, "Russia"));
        userList.add(new User(2, "Mohamed", "Salah", 30, "Egypt"));
        userList.add(new User(3, "Jude", "Bellingham", 19, "England"));
        userList.add(new User(4, "Romelu", "Lukaku", 29, "Belgium"));
        userList.add(new User(5, "Federico", "Chiesa", 25, "Italy"));
        userList.add(new User(6, "Pedro", "Gonzalez", 20, "Spain"));

        List<User> list1 = userList.stream().sorted(Comparator.comparing(User::getAge)).toList();
        list1.forEach(System.out::println);
        System.out.println();

        Map<Long, List<User>> map2 = userList.stream().collect(Collectors.groupingBy(User::getId));
        map2.forEach((aLong, users) -> System.out.println(aLong + ": " + users));
        System.out.println();

        long count3 = userList.stream().map(User::getNationality).distinct().count();
        System.out.println("Количество разных национальностей: " + count3);
        System.out.println();

        userList.stream().filter(user -> (user.getFirstName().charAt(0) != 'M')).filter(user -> (user.getAge() > 10)).toList().forEach(System.out::println);
    }
}
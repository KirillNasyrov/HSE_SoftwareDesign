package kirillnasyrov;

public class Person {
    String name;
    String secondName;

    public Person(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getInformation() {
        return name + " " + secondName;
    }
}

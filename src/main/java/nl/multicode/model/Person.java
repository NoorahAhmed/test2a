package nl.multicode.model;

import java.util.List;

public class Person {

    private final String name;
    private final int age;
    private final List<Person> children;

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
        this.children = List.of();
    }

    public Person(String name, int age, List<Person> children) {

        this.name = name;
        this.age = age;
        this.children = children;
    }


    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public List<Person> getChildren() {

        return children != null ? children : List.of();
    }

    public String toString() {

        return "User: [name: [" + name + "], age: [" + age + "]]";
    }

}

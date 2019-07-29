package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User o) {
        return (this.age == o.age) ? (this.name.compareTo(o.name)) : Integer.compare(this.age, o.age);
    }
}
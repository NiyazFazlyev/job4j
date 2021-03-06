package ru.job4j.stream;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public int getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(student.getScore(), this.score);
    }
}

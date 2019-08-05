package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenCreate10A() {
        List<Student> students = new LinkedList<>();
        Student student1 = new Student(15);
        Student student2 = new Student(89);
        Student student3 = new Student(55);
        Student student4 = new Student(69);
        Student student5 = new Student(20);
        Student student6 = new Student(40);
        Student student7 = new Student(75);
        students.addAll(Arrays.asList(student1, student2, student3, student4, student5, student6, student7));
        List<Student> result = School.collect(students, n -> n.getScore() >= 70);
        List<Student> expect = new ArrayList<>(Arrays.asList(student2, student7));
        assertThat(result, is(expect));
    }

    @Test
    public void whenCreate10B() {
        List<Student> students = new LinkedList<>();
        Student student1 = new Student(15);
        Student student2 = new Student(89);
        Student student3 = new Student(55);
        Student student4 = new Student(69);
        Student student5 = new Student(20);
        Student student6 = new Student(40);
        Student student7 = new Student(75);
        students.addAll(Arrays.asList(student1, student2, student3, student4, student5, student6, student7));
        List<Student> result = School.collect(students, n -> (n.getScore() >= 50) && (n.getScore() < 70));
        List<Student> expect = new ArrayList<>(Arrays.asList(student3, student4));
        assertThat(result, is(expect));
    }

    @Test
    public void whenCreate10C() {
        List<Student> students = new LinkedList<>();
        Student student1 = new Student(15);
        Student student2 = new Student(89);
        Student student3 = new Student(55);
        Student student4 = new Student(69);
        Student student5 = new Student(20);
        Student student6 = new Student(40);
        Student student7 = new Student(75);
        students.addAll(Arrays.asList(student1, student2, student3, student4, student5, student6, student7));
        List<Student> result = School.collect(students, n -> n.getScore() < 50);
        List<Student> expect = new ArrayList<>(Arrays.asList(student1, student5, student6));
        assertThat(result, is(expect));
    }
}


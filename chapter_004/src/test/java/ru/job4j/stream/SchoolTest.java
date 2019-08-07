package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void whenCreateMap() {
        Student student1 = new Student("Petr", 15);
        Student student2 = new Student("Oleg", 89);
        Student student3 = new Student("Ivan", 55);
        List<Student> students = new LinkedList<>(Arrays.asList(student1, student2, student3, student1));
        Map<String, Student> expect = new LinkedHashMap<>();
        expect.put("Petr", student1);
        expect.put("Oleg", student2);
        expect.put("Ivan", student3);
        Map<String, Student> result = School.toMap(students);
        assertThat(result, is(expect));
    }

    @Test
    public void whenScoreMore50() {
        Student student1 = new Student(15);
        Student student2 = new Student(89);
        Student student3 = new Student(55);
        Student student4 = new Student(69);
        Student student5 = new Student(20);
        Student student6 = new Student(40);
        Student student7 = new Student(75);
        List<Student> students = new ArrayList<>(Arrays.asList(student1, null, student2, student3, student4, student5, student6, student7));
        List<Student> result = School.levelOf(students, 50);
        List<Student> expect = new ArrayList<>(Arrays.asList(student2, student7, student4, student3));
        assertThat(result, is(expect));
    }
}


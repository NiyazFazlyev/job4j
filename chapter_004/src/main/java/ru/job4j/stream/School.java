package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static Map<String, Student> toMap(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.toMap(e -> e.getName(), e -> e, (oldValue, newValue) -> oldValue));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(n -> n.getScore() > bound)
                .collect(Collectors.toList());
    }
}

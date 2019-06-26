package ru.job4j.pseudo;

public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder()
                .append("++++++")
                .append(System.lineSeparator())
                .append("+    +")
                .append(System.lineSeparator())
                .append("+    +")
                .append(System.lineSeparator())
                .append("+    +")
                .append(System.lineSeparator())
                .append("+    +")
                .append(System.lineSeparator())
                .append("++++++");
        return pic.toString();
    }
}

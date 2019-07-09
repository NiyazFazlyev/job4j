package ru.job4j.singleton;

public class LoadOrder {

    private static final String STATIC_FINAL_FIELD = echo("static final field");
    private static String static_field = echo("static field");

    static {
        echo("static block");
    }

    private final String name = echo("final field");
    private String surname = echo("field");

    {
        echo("not-static block");
    }

    public LoadOrder(String msg) {
        echo("constructor " + msg);
    }

    public static String echo(String text) {
        System.out.println(text);
        return text;
    }

    public static LoadOrder getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {

        LoadOrder order = LoadOrder.getInstance();
    }

    private static final class Holder {
        private static final LoadOrder INSTANCE = new LoadOrder("static inner field");
        private static String static_inner_field = echo("static field in Holder");
    }
}
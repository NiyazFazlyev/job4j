package ru.job4j.dagger;

import ru.job4j.tracker.Input;

import javax.inject.Inject;

public class Calc {
    private final Input input;
    private final Output output;

    @Inject
    public Calc(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void add(){
        int first = Integer.valueOf(input.ask("first: "));
        int second = Integer.valueOf(input.ask("second: "));
        output.consolePrint("result: " + (first + second));
    }

    public static void main(String[] args) {
        InputComponent component = DaggerInputComponent.create();
        component.instance().add();
    }
}


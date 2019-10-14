package ru.job4j.dagger;

import dagger.Component;
import jdk.jfr.Category;

@Component(modules = InputModule.class)
public interface InputComponent {
    Calc instance();
}


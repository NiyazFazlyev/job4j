package ru.job4j.calculator;

/**
 *Calculator
 *Ифышс operations of a simple calculator.
 *@author Niyaz Fazlyev
 */

public class Calculator {

    /**
     * Method add.
     * @param first first argument.
     * @param second second argument.
     * @return first + second.
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Method add.
     * @param first first argument.
     * @param second second argument.
     * @return first - second.
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Method add.
     * @param first first argument.
     * @param second second argument.
     * @return first / second.
     */
    public double div(double first, double second) {
        return first  / second;
    }

    /**
     * Method add.
     * @param first first argument.
     * @param second second argument.
     * @return first * second.
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}


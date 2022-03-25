package ru.muctr.Exceptions;

/**
 * @author Evgenia Skichko
 */
//пример пользовательского класса исключения
public class NumberInvalidForFactorialException extends Exception {
    int value;
    NumberInvalidForFactorialException (int val){
        value = val;
    }

    @Override
    public String toString() {
        return "Невозможно рассчитать факториал числа " + value;
    }
}

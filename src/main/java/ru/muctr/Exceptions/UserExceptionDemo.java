package ru.muctr.Exceptions;

public class UserExceptionDemo {
    public static void main(String[] args){
        int value = -4;
        try {
            System.out.println("Факториал " + value + " равен " + Factorial.getFactorial(value));
        } catch (NumberInvalidForFactorialException e){
            System.out.println(e);
        }
    }
}

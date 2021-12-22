package model;
//класс ошибки при рабо е калькулятора

public class CalculatorException extends RuntimeException{

    public CalculatorException(String message) {
        super(message);
    }
}
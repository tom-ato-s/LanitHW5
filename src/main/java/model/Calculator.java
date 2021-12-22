package model;
/*
Класс Калькулятор.
Содержит метод, для работы с калькулятором
В классе прописаны логи
 */
//        import org.apache.logging.log4j.LogManager;
//        import org.apache.logging.log4j.Logger;
import java.util.Locale;

public class Calculator {
    //Создание Лога
//    static final Logger LOGCal = LogManager.getLogger(Calculator.class);
    /*
    проверяет первое входное значение метода execute() на корректность
    метод public - должен быть private/
    сделала позитывную проверку для него
    */
    public static boolean isZnak(String string) {
        boolean flag = false;
        if (string == null)
            return false;
        int length = string.length();
        int iterator = 0;//current iterator
        //if empty string
        if (length == 0)
            return false;
        //miss backspaces and tab
        while (iterator < length) {
            if ((string.charAt(iterator) == ' ') || (string.charAt(iterator) == '\t')) {
                iterator++;
            } else {
                break;
            }
        }
        //check math operator
        if ((string.charAt(iterator) == '+') || (string.charAt(iterator) == '-') ||
                (string.charAt(iterator) == '*') || (string.charAt(iterator) == '/')) {
            flag = true;
            iterator++;
        }
        //miss backspaces and tab
        while (iterator < length) {
            if ((string.charAt(iterator) == ' ') || (string.charAt(iterator) == '\t')) {
                iterator++;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    /*метод public - должен быть private/
      сделала позитывную проверку для него
      Метод проверяет-являются ди второе и третье введенное значение типа double
       возвращает значение boolean
    */
    public static boolean isDouble(String string) {
        boolean point = false;//find decimal point in the string
        if (string == null){
            return false;
        }
        int length = string.length();
        int iterator = 0;//current iterator
        //if empty string
        if (length == 0){
            return false;
        }
        //miss backspaces and tab
        while (iterator < length) {
            if ((string.charAt(iterator) == ' ') || (string.charAt(iterator) == '\t')) {
                iterator++;
            } else {
                break;
            }
        }
        if (iterator == length)
            return false;
        //check is digit negative or positive
        if ((string.charAt(iterator) == '+') || (string.charAt(iterator) == '-')) {
            iterator++;
        }
        if (iterator == length)
            return false;
        //check digit symbols
        while (iterator < length) {
            //check decimal pointer
            if ((string.charAt(iterator) == '.') || (string.charAt(iterator) == ',')) {
                if (!point) {
                    point = true;
                    iterator++;
                    continue;
                } else//second decimate pointer is deprecated
                {
                    return false;
                }
            }
            //check digits
            if ((string.charAt(iterator) >= '0') && (string.charAt(iterator) <= '9')) {
                iterator++;
            }
            else return false;
        }
        return iterator == length;
    }

    //метод проверяет корректновть введеных данных метода execute()
    private static boolean isCorrectFormat(String[] params){
        return isZnak(params[0]) && (isDouble(params[1])) && (isDouble(params[2]));
    }

    //Основой метод класса.
    // Метод статический, для проведения расчета
    public static String execute(String[] params)  {
        String oneString;
        String rezString;
        double twoDouble;
        double treeDouble;
        double rezDouble;
        if (params.length != 3)
            throw new CalculatorException(" Ошибка исходных данных");
        //Информационный Лог
//        LOGCal.info("Старт программы Calculator");
        if(isCorrectFormat(params)){
            oneString = params[0];
            twoDouble = Double.parseDouble(params[1]);
            treeDouble = Double.parseDouble(params[2]);
        } else {
            throw new CalculatorException("Введен не правильный тип данных");
        }//информационный лог
//        LOGCal.info("Парсинг входных параметров");
        if (oneString.contains("+")){
            rezDouble = twoDouble+ treeDouble;
        } else if (oneString.contains("-")){
            rezDouble =twoDouble- treeDouble;
        } else if (oneString.contains("*")){
            rezDouble =twoDouble* treeDouble;
        } else if (oneString.contains("/")) {
            if (treeDouble == 0) {
                throw new CalculatorException(" Ошибка деления на ноль");
            } else {
                rezDouble = twoDouble / treeDouble;
            }
        } else {
            System.out.println("Неверно введен знак");
            rezString = "";
            return rezString;
        }
        // информационный лог
//        LOGCal.info("Проведение арифметических операций с входными данными");
        if(rezDouble<100&&rezDouble>-100) {
//            LOGCal.info("Проверка результата на соблюдение ограничений");
            if(rezDouble * 10 -  (int)(rezDouble * 10)==0.) {
                rezString = String.format(Locale.ROOT, "%.1f", rezDouble);
                return rezString;
            }else if (rezDouble * 100 -  (int)(rezDouble * 100)==0.) {
                rezString = String.format(Locale.ROOT, "%.2f", rezDouble);
                return rezString;
            } else
                rezString = String.format(Locale.ROOT, "%.3f", rezDouble);
            return rezString;
        } else {
            throw new CalculatorException(" Не верное значение, результат вышел за установленные границы: (-100, 100)");
        }
    }

}

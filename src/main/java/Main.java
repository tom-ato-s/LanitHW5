/* Главный класс программы
производится ввод данных с консоли
записывание их в массив,
проведение арифметических операций, вывод в консоль результатов
 */
import model.Calculator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {
//    static final Logger LOGMain = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args != null)
            if (args.length > 0)
                if (args[0].equals("-h")||args[0].equals("--help"))
                {
                    System.out.println("Калькулятор, требуется ввод 3 строк\n" +
                            "знак, первое число, второе число.\n" +
                            "вычисляет в пределах от -100 до 100");
                }
        //создание массива для вводимых данных
        //       LOGMain.info("запуск программы Main");
        String[] arr = {"","",""};
        Scanner in = new Scanner(System.in);
        //ввод данных в цикле и запись в массив
        for (int i = 0; i < 3; i++) {
            String line = in.nextLine();
            if(line != null){
                arr[i] = line;
            }
            else
            {
                i--;
            }
        }
//        LOGMain.info("ввод данных с консоли");
        //проведение расчетов и вовод в консоль
        String res = Calculator.execute(arr);
        if (res != null)
            System.out.println(res);
        //       LOGMain.info("Проведение расчетов и вовод в консоль  результатов");
    }
}

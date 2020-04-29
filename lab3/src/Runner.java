import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;

import java.util.Set;

public class Runner {
    public static Manager manager = new Manager();

    public static void main(String[] argv){
        /**
         * Первое задание. Результат выводится в консоль.
         */
        Transform transform = new Transform();
        transform.setStr("I've seen things you people wouldn't believe.");
        transform.firtstTask("woul","I", "gs");
        /**
         * Второе задание. Результат выводится в консоль.
         */
        transform.setStr("My first phone number is 11-25-82 and second is 22-54-43");
        transform.secondTask();
        /**
         * Третье задание. Вводи и вывод строки производится в всплывающем окно.
         */
        manager.createWindow(transform);
        /**
         * Четвертое задание.Результат выводится в консоль.
         */
        transform.setStr("All those moments will be lost in time, like tears in rain.");
        System.out.println("\nFourth Task:");
        transform.fourthTask(1, "A", "o");
        transform.fourthTask(2, "A", "o");

    }

}

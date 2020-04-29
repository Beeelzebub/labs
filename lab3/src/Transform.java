import by.vsu.mf.ai.ssd.strings.Job;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Transform implements Job {
    private String str;
    private int length;
    /**
     * Первое задание. Сначала сортирует от первого вхождения s до конца строки.
     * Потом от первого вхождения first_s и до последнего вхождения second_s.
     * Выводит в консоль первоначальное состояние, после первой сортировки и после второй.
     */
    public void firtstTask(String s, String first_s, String second_s){
        stringOutput("\nFirst task:\n");
        int from, to;
        char[] temp = str.toCharArray();
        from = str.indexOf(s);
        Arrays.sort(temp, from, str.length());
        System.out.println(temp);
        from = str.indexOf(first_s);
        to = str.lastIndexOf(second_s);
        Arrays.sort(temp, from, to);
        System.out.println(temp);
    }
    /**
     * Второе задание. Метод проходит поэлементно. Если натыкается на число, то отправляет в метод
     * checkSubstring подстроку для сравнения с регулярным выражением. В случае, если метод checkSubstring вернул
     * true, добавляет эту подстроку в конец строки и прибавляет длину подстроки к i. Так до конца строки.
     * После чего выводит в консоль результат.
     */
    public void secondTask(){
        stringOutput("\nSecond Task:\n");
        StringBuilder strb = new StringBuilder(str);
        for (int i = 0; i < length; i++){
            if (strb.charAt(i) >= 48 && strb.charAt(i) <= 57 && i + 7 < length){
                if (checkSubstring(strb.substring(i, (i + 8)))){
                    if (strb.length() > length) strb.append(",");
                    strb.append(" " + strb.substring(i, (i + 8)));
                    i += 7;
                }
            }
        }
        System.out.println(strb);
    }
    /**
     * Третье задание. Реализация метода perform интерфейса Job. Повторяет алгоритм второго задания.
     */
    public void perform(StringBuilder strb){
        length = strb.length();
        for (int i = 0; i < length; i++){
            if (strb.charAt(i) >= 48 && strb.charAt(i) <= 57 && i + 7 < length){
                if (checkSubstring(strb.substring(i, (i + 8)))){
                    if (strb.length() > length) strb.append(",");
                    strb.append(" " + strb.substring(i, (i + 8)));
                    i += 7;
                }
            }
        }
    }

    /**
     * Четвертое задание. Метод создает объект класса Sort, в котором реализованы 2 типа сортировки
     * "Bubble sort" и "Shell sort". Параметр type_of_sort определяет какой тип сортировки использовать.
     * Сортировка происходит от первого вхождения подстроки first_s и до последнего схождения подстроки second_s.
     */
    public void fourthTask(int type_of_sort, String first_s, String second_s){
        int from = str.indexOf(first_s);
        int to = str.lastIndexOf(second_s);
        Sort<Character> sort = new Sort<Character>();
        Character[] arr = str.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
        sort.setObj(arr);
        if (type_of_sort == 1) {
            from = str.indexOf(first_s);
            to = str.lastIndexOf(second_s);
            sort.bubbleSort(from, to);
        }
        else {
            from = str.indexOf(first_s);
            to = str.lastIndexOf(second_s);
            sort.shellSort(from, to);
        }
    }

    private boolean checkSubstring(String substring){
        if (substring.matches("\\d{2}(\\-)\\d{2}(\\-)\\d{2}")) return true;
        else return false;
    }

    public void stringOutput(String s){
        System.out.println(s + str);
    }

    public void setStr(String str) {
        this.str = str;
        length = str.length();
    }
}

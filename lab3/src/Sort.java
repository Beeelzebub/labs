import javax.management.ObjectName;
import java.util.Comparator;

/**
 * Обобщенный класс, реализующий 2 типа сортировки "Bubble sort" - метод bubbleSort и "Shell sort" - метод shellSort.
 * В классе реализован метод compare интерсфеса Comparator. Для того, чтобы стало возможным сравнивать различные типы
 * два сравниваемых объекта преобразуются в String. Поля count_of_comparisons и count_of_swaps ведут счёт
 * количества сравнений и перестановок соответственно.
 */
public class Sort <T> implements Comparator<T>{
    private int count_of_comparisons;
    private int count_of_swaps;
    private T[] obj;

    public void setObj(T[] obj) {
        this.obj = obj;
    }

    public void bubbleSort(int from, int to) {
        this.arrOut();
        count_of_comparisons = 0;
        count_of_swaps = 0;
        T temp;
        for (int j = from; j < to - 1; j++) {
            for (int i = from; i < to; i++) {

                if (this.compare(obj[i], obj[i + 1]) > 0) {
                    this.swap(i, i + 1);
                }
            }
        }
        resultOut("Bubble sort");
    }

    public void shellSort(int from, int to){
        this.arrOut();
        count_of_comparisons = 0;
        count_of_swaps = 0;
        int length = to - from;
        for (int inc = length / 2; inc >= 1; inc = inc / 2)
            for (int step = from; step < inc; step++) {
                for (int i = step; i < length; i += inc)
                    for (int j = Math.min(i+inc, length); j-inc >= from; j = j-inc)
                        if (this.compare(obj[j - inc], obj[j]) > 0)
                        {
                            this.swap(j, j-inc);
                        }
                        else break;
            }
        resultOut("Shell sort");
    }

    private void swap(int from, int to){
        count_of_swaps++;
        T temp = obj[from];
        obj[from] = obj[to];
        obj[to] = temp;
    }

    public void arrOut(){
        for (int i = 0; i < obj.length; i++)
            System.out.print(obj[i]);
    }

    public void resultOut(String sort_type){
        System.out.print("\n" + sort_type + ":");
        arrOut();
        System.out.println("\nCount of comparisons: " + count_of_comparisons);
        System.out.println("Count of swaps: " + count_of_swaps + "\n");
    }

    @Override
    public int compare(T o1, T o2) {
        count_of_comparisons++;
        return o1.toString().compareTo(o2.toString());
    }
}

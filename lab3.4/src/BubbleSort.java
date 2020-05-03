import java.util.Comparator;

public class BubbleSort implements Sort {

    private int count_of_comparisons;
    private int count_of_swaps;

    @Override
    public void sort(Object[] obj, Comparator comparator) {
        count_of_comparisons = 0;
        count_of_swaps = 0;
        for (int j = 0; j < obj.length - 1; j++) {
            for (int i = 0; i < obj.length - 1; i++) {
                count_of_comparisons++;
                if (comparator.compare(obj[i], obj[i + 1]) > 0) {
                    this.swap(obj, i, i + 1);
                }
            }
        }
        resultOut();
    }

    private void swap(Object[] obj, int from, int to){
        count_of_swaps++;
        Object temp = obj[from];
        obj[from] = obj[to];
        obj[to] = temp;
    }

    public void resultOut(){
        System.out.println("\nBubble sort info:");
        System.out.println("Count of comparisons: " + count_of_comparisons);
        System.out.println("Count of swaps: " + count_of_swaps);
    }
}

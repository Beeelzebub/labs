import java.util.Comparator;

public class ShellSort implements Sort {
    private int count_of_comparisons;
    private int count_of_swaps;

    @Override
    public void sort(Object[] obj, Comparator comparator) {
        count_of_comparisons = 0;
        count_of_swaps = 0;
        int length = obj.length - 1;
        for (int inc = length / 2; inc >= 1; inc = inc / 2)
            for (int step = 0; step < inc; step++) {
                for (int i = step; i < length; i += inc)
                    for (int j = Math.min(i+inc, length); j-inc >= 0; j = j-inc) {
                        count_of_comparisons++;
                        if (comparator.compare(obj[j - inc], obj[j]) > 0) {
                            this.swap(obj, j, j - inc);
                        } else break;
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
        System.out.println("\nShell sort info:");
        System.out.println("Count of comparisons: " + count_of_comparisons);
        System.out.println("Count of swaps: " + count_of_swaps);
    }
}

import java.util.Arrays;

public class Runner {
    public static void main (String[] args){
        String[] argsClone = args.clone();
        //Пример с сортировкой обмена
        BubbleSort bs = new BubbleSort();
        strOut(args);
        bs.sort(args, new StringComparator("f"));
        strOut(args);
        bs.sort(args, new StringComparator("f", "a"));
        strOut(args);

        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        //Пример с сортировкой Шелла
        ShellSort ss = new ShellSort();
        strOut(argsClone);
        ss.sort(argsClone, new StringComparator("f"));
        strOut(argsClone);
        ss.sort(argsClone, new StringComparator("f", "a"));
        strOut(argsClone);
    }

    public static void strOut(Object[] objects){
        for(int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println(" ");
    }
}

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        strOut(args);
        Arrays.sort(args, new StringComparator("f"));
        strOut(args);
        Arrays.sort(args, new StringComparator("a", "f"));
        strOut(args);

    }

    public static void strOut(String[] strings){
        for(int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println(" ");
    }
}

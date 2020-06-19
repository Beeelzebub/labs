import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    private String s;
    private String firstString;
    private String secondString;
    private int from;
    private int to;
    private boolean flag;

    public StringComparator(String s){
        this.s = s;
        this.flag = true;
    }

    public StringComparator(String firstString, String secondString){
        this.firstString = firstString;
        this.secondString = secondString;
        this.flag = false;
    }

    public int compare(String s1, String s2) {
       if (flag) {
           return s1.indexOf(s) - s2.indexOf(s);
       } else {
           setBounds(s1);
           String tempS1 = new String(s1.substring(from, to));
           setBounds(s2);
           String tempS2 = new String(s2.substring(from, to));
           return tempS1.compareToIgnoreCase(tempS2);
       }
    }

    private void setBounds(String str) {
        if (str.indexOf(firstString) > str.lastIndexOf(secondString)) {
            this.from = str.lastIndexOf(secondString);
            this.to = str.indexOf(firstString);
        } else {
            this.from = str.indexOf(firstString);
            this.to = str.lastIndexOf(secondString);
        }
    }
}

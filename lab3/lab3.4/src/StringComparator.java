import java.util.Comparator;

public class StringComparator implements Comparator<Object> {
    private String s;
    private String firstString;
    private String secondString;
    private int from;
    private int to;
    private boolean taskFlag;
    private boolean nonTaskFlag;


    public StringComparator(){
        this.nonTaskFlag = true;
    }

    public StringComparator(String s){
        this.s = s;
        this.taskFlag = true;
        this.nonTaskFlag = false;
    }

    public StringComparator(String firstString, String secondString){
        this.firstString = firstString;
        this.secondString = secondString;
        this.taskFlag = false;
        this.nonTaskFlag = false;
    }

    public int compare(Object s1, Object s2) {
        if (taskFlag && !nonTaskFlag) {
            return s1.toString().indexOf(s) - s2.toString().indexOf(s);
        }
        else if (!taskFlag && !nonTaskFlag) {
            setBounds(s1);
            String tempS1 = new String(s1.toString().substring(from, to));
            setBounds(s2);
            String tempS2 = new String(s2.toString().substring(from, to));
            return tempS1.compareToIgnoreCase(tempS2);
        }
        else {
             return ((Comparable) s1).compareTo(s2);
        }
    }

    private void setBounds(Object str) {
        if (str.toString().indexOf(firstString) > str.toString().lastIndexOf(secondString)) {
            this.from = str.toString().lastIndexOf(secondString);
            this.to = str.toString().indexOf(firstString);
        } else {
            this.from = str.toString().indexOf(firstString);
            this.to = str.toString().lastIndexOf(secondString);
        }
    }
}

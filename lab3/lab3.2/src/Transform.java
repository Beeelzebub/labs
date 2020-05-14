import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Transform {
    private String str;
    private int length;

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
        str = strb.toString();
        System.out.println(strb);
    }

    public String getStr() {
        return str;
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

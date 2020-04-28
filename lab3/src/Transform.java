import by.vsu.mf.ai.ssd.strings.Job;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Transform implements Job {
    String str;
    int length;

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

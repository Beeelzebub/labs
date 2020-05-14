package bin;

public class Calc {

    public static void main(String args[]){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);        
        Input(Calculate(a, b, c));
    }

    public static void Input(double value){
        System.out.println("Answer is " + value);
    }

    public static double Calculate(double a, double b, double c){
        return ((Math.pow(a,2) + 1)/(b-(1/(Math.pow(c,2)+1))));
    }
}
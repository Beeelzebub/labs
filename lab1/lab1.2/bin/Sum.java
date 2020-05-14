package bin;

public class Sum {
    public static void main(String args[]){
        double x = Double.parseDouble(args[0]);
        double alpha = Double.parseDouble(args[1]);
        ResultInput(x, alpha);
    }

    public static void ResultInput(double x, double alpha){
        System.out.println("Sum of the row is " + Summation(x, alpha));
        System.out.println("sinh(x) is " + Math.sinh(x));
    }

    public static double Summation(double x, double alpha){
        double current = 0;
        double pre = 0;
        for(int n = 0; EndChecking(pre, current, alpha); n++){
            pre = current;
            current += Calc(x, n);
        }
        return current;
    }

    public static double Calc(double x, int n){
        return (Math.pow(x,(2 * n + 1)) / Factorial((2 * n + 1)));
    }

    public static int Factorial(int n)
    {
        int ret = 1;
        for (int i = 1; i <= n; ++i) ret *= i;
        return ret;
    }

    public static boolean EndChecking(double pre, double current, double alpha){
        if(pre == 0 || Math.abs((current - pre)) > alpha) return true;
        else return false;
    }
}

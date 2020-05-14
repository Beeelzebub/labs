package by.vsu;

public class Runner {
	public static double expression(int a, double b){
		return b/a;
	}
	
    public static void main(String args[]) {
		int a = Integer.parseInt(args[0]);
        double b = Double.parseDouble(args[1]);
		System.out.println(expression(a,b));
    }
}
public class Circle extends Point {
    protected double radius;
    protected Point inscribed_center;

    public Circle(double x0, double y0, double radius){
        super(x0, y0);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setInscribedCenter(Triangle triangle){
        double lentgth_sum = triangle.getAB_length() + triangle.getAC_length() + triangle.getBC_length();
        double y = (triangle.getBC_length() * triangle.getA().getY() + triangle.getAB_length() * triangle.getC().getY() + triangle.getAC_length() * triangle.getB().getY()) / lentgth_sum;
        double x = (triangle.getBC_length() * triangle.getA().getX() + triangle.getAB_length() * triangle.getC().getX() + triangle.getAC_length() * triangle.getB().getX()) / lentgth_sum;
        inscribed_center = new Point(x, y);
    }

    public double getInscribedRadius(Triangle triangle){
        double p = (triangle.getAB_length() + triangle.getAC_length() + triangle.getBC_length()) * 0.5;
        return Math.sqrt(((p - triangle.getAB_length()) * (p - triangle.getBC_length()) * (p - triangle.getAC_length()))/p);
    }

    public Point getInscribed_center() {
        return inscribed_center;
    }
}

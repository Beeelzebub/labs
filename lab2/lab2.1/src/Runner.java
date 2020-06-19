public class Runner {
    public static void main(String[] args){
        Circle circle = new Circle(3,3,1);
        Point point = new Point(1, 1);
        Triangle triangle = new Triangle(circle, point);
        circle.setInscribedCenter(triangle);
        System.out.println("Center of inscribed circle: {" + circle.getInscribed_center().getX() + ", " + circle.getInscribed_center().getY() + "}");
        System.out.println("Radius of inscribed circle: " + circle.getInscribedRadius(triangle));
        System.out.println("B:  {" + triangle.getB().getX() + ", " + triangle.getB().getY() + "}");
        System.out.println("C:  {" + triangle.getC().getX() + ", " + triangle.getC().getY() + "}");
    }
}

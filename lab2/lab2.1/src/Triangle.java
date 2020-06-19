public class Triangle {
    protected Point A;
    protected Point B;
    protected Point C;
    protected double ab_length;
    protected double ac_length;
    protected double bc_length;
    Tangent tangent;

    public Triangle(Circle first_coord, Point secont_coord){
        tangent = new Tangent(first_coord, secont_coord);
        A = secont_coord;
        B = tangent.getFirstPoint();
        C = tangent.getSecondPoint();
        ab_length = tangent.getLength();
        ac_length = tangent.getLength();
        bcLengthCounting();
    }

    private void bcLengthCounting(){
        this.bc_length = Math.sqrt(Math.pow((B.getX() - C.getX()), 2) + Math.pow((B.getY() - C.getY()), 2));
    }

    public double getAB_length() {
        return ab_length;
    }

    public double getAC_length() {
        return ac_length;
    }

    public double getBC_length() {
        return bc_length;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }
}

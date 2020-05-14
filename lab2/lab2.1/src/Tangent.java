public class Tangent {
    protected Point tg_coord[] = new Point[2];
    protected double length;
    Circle auxiliary_circle;

    public Tangent(Circle first_coord, Point second_coord){
        setLength(first_coord.getX(), first_coord.getY(), second_coord.getX(), second_coord.getY());
        setAuxiliary_circle(first_coord.getX(), first_coord.getY(), second_coord.getX(), second_coord.getY());
        setTangentPointCoordinate(first_coord.getX(), first_coord.getY(), second_coord.getX(), second_coord.getY(), first_coord.radius);
    }

    private void setLength(double X, double Y, double Xo, double Yo) {
        double dx = X - Xo;
        double dy = Y - Yo;
        this.length = Math.sqrt(dx * dx + dy * dy);
    }

    private void setAuxiliary_circle(double X, double Y, double Xo, double Yo){
        double temp_X = (Xo + X) / 2;
        double temp_Y = (Yo + Y) / 2;
        double temp_rad = Math.sqrt(((Xo - X) * (Xo - X) + (Yo - Y) * (Yo - Y)) / 2);
        auxiliary_circle = new Circle(temp_X, temp_Y, temp_rad);
    }

    private void setTangentPointCoordinate(double Xo, double Yo, double X, double Y, double rad){
        double R1 = rad;
        double R2 = auxiliary_circle.getRadius();
        double D = Math.sqrt((Xo - X) * (Xo - X) + (Yo - Y) * (Yo - Y));
        double a = (R1 * R1 - R2 * R2 + D * D) / (2 * D);
        double h = Math.sqrt(R1 * R1 - a * a);

        double temp_X = Xo + a * (X - Xo) / D;
        double temp_Y = Yo + a * (Y - Yo) / D;

        double tgX = temp_X + h * (Y - Yo) / D;
        double tgY = temp_Y - h * (X - Xo) / D;
        this.tg_coord[0] = new Point(tgX, tgY);

        tgX = temp_X - h * (Y - Yo) / D;
        tgY = temp_Y + h * (X - Xo) / D;
        this.tg_coord[1] = new Point(tgX, tgY);
    }

    public double getLength() {
        return length;
    }

    public Point getFirstPoint(){
        return tg_coord[0];
    }

    public Point getSecondPoint(){
        return tg_coord[1];
    }
}

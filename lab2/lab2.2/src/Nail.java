public class Nail {
    private int x;
    private boolean bonds;
    private int position;
    public Nail(int position, int x){
        this.x = x;
        bonds = false;
        this.position = position;
    }

    public void bind(){
        bonds = true;
    }

    public int getX() {
        return x;
    }

    public int getPosition() {
        return position;
    }

    public boolean isBinded(){
        return bonds;
    }
}

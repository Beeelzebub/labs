public class Rope {
    private int nails_count;
    private Nail[] nails;
    private int length;

    public Rope(int[] coord) {
        length = 0;
        nails_count = coord.length;
        setNails(coord, nails_count);
    }

    public void setNails(int[] coord, int length) {
        nails = new Nail[length];
        for (int i = 0; i < length; i++) {
            nails[i] = new Nail((i + 1), coord[i]);
        }
    }

    public void binding3() {
        int compare, temp_left, temp_right, temp_next = 100, position, j;
        boolean flag;
        for (int i = 0; i < nails_count; i++) {
            compare = 100;
            position = 0;
            flag = false;

            if (i == 0){
                temp_right = Math.abs(nails[i].getX() - nails[i + 1].getX());
                position = i + 1;
                compare = temp_right;
                flag = true;
            }
            else if ((i == (nails_count - 1)) && (!nails[i].isBinded())){
                temp_left = Math.abs(nails[i].getX() - nails[i - 1].getX());
                position = i - 1;
                compare = temp_left;
                flag = true;
            }
            else if (!nails[i].isBinded()) {
                temp_left = Math.abs(nails[i].getX() - nails[i - 1].getX());
                temp_right = Math.abs(nails[i].getX() - nails[i + 1].getX());
                if (i != nails_count - 2) temp_next = Math.abs(nails[i + 1].getX() - nails[i + 2].getX());

                if ((i != nails_count - 2) && this.length + temp_next <= this.length + temp_right + temp_left){
                    if (this.length + temp_right <= this.length + temp_left) {
                        nails[i].bind();
                        nails[i + 2].bind();
                        nails[i + 1].bind();
                        System.out.println("(" + nails[i].getPosition() + ", " + nails[i + 1].getPosition() + ")");
                        System.out.println("(" + nails[i + 1].getPosition() + ", " + nails[i + 2].getPosition() + ")");
                        this.length += temp_right + temp_next;
                        i++;
                    }
                    else {
                        nails[i].bind();
                        nails[i - 1].bind();
                        nails[i + 2].bind();
                        System.out.println("(" + nails[i].getPosition() + ", " + nails[i - 1].getPosition() + ")");
                        System.out.println("(" + nails[i + 1].getPosition() + ", " + nails[i + 2].getPosition() + ")");
                        this.length += temp_left + temp_next;
                        i++;
                    }
                }
                else if (this.length + temp_right <= this.length + temp_left + temp_right) {
                    position = i + 1;
                    compare = temp_right;
                    flag = true;
                }
                else {
                    position = i - 1;
                    compare = temp_left;
                    flag = true;
                }

            }

            if (flag){
                this.length += compare;
                System.out.println("(" + nails[i].getPosition() + ", " + nails[position].getPosition() + ")");
                nails[i].bind();
                nails[position].bind();
            }
        }
        System.out.println("Length of rope is " + this.length);
    }
}


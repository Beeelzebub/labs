package bin;

import by.vsu.mf.ai.ssd.painting.Painter;

public class Draw {

    public static void main(String args[]){
		double fi = Double.parseDouble(args[0]);
        drawing(coordFind(fi), (short)((2 * Math.PI)/fi));
    }
    public static double[][][] coordFind(double step){
        double coords[][][] = new double[(int)(((2 * Math.PI)/step)+1)][2][2];
        int i = 0;
        for(double angle = 0; angle <= (2 * Math.PI); angle += step) {
            for (int j = 0; j < 2; j++) {
                coords[i][j][0] = getX(getFunc(j, angle), angle);
                coords[i][j][1] = getY(getFunc(j, angle), angle);
            }
            i++;
        }
        return coords;
    }
    public static double firstFunc(double angle){
        return angle/(2*Math.PI);
    }
    public static double secondFunc(double angle){
        return  (1 + Math.sin(angle) * Math.sin(angle))/2;
    }
    public static double getX(double rad, double angle){
        return rad * Math.cos(angle);
    }
    public static double getY(double rad, double angle){
        return rad * Math.sin(angle);
    }
    public static double getFunc(int j, double angle){
        if(j == 0) return firstFunc(angle);
        else return secondFunc(angle);
    }
    public static void drawing(double coord[][][], short length){
        Painter.paint(800, 650, coord, colorArrayCreate(length, getColorStep(length)));
    }
    public static short getColorStep(short length){
        if(length > 1275) return  1;
        else return  (short)(Math.ceil(1275/length));
    }
    public static short[][] colorArrayCreate(short length, short step){
        short color[][] = new short[length][3];

        for(short i = 0; i < length; i++) {
            if(i == 0) color = setColor(color, i, (short)0, (short)0, (short)255);
            else if ((color[i - 1][0] == 0) && (color[i - 1][1] < 255) && (color[i - 1][2] == 255)) color = setColor(color, i, (short)0, step, (short)0);
            else if ((color[i - 1][0] == 0) && (color[i - 1][1] == 255) && (color[i - 1][2] <= 255) && (color[i - 1][2] != 0)) color = setColor(color, i, (short)0, (short)0, (short)(step * -1));
            else if ((color[i - 1][0] < 255) && (color[i - 1][1] == 255) && (color[i - 1][2] == 0)) color = setColor(color, i, step, (short)0, (short)0);
            else if ((color[i - 1][0] == 255) && (color[i - 1][1] <= 255) && (color[i-1][1] != 0) && (color[i - 1][2] == 0)) color = setColor(color, i, (short)0, (short)(step * -1), (short)0);
            else if ((color[i - 1][0] == 255) && (color[i - 1][1] == 0) && (color[i - 1][2] < 255)) color = setColor(color, i, (short)0, (short)0, step);
            else if ((color[i - 1][0] <= 255) && (color[i - 1][0] != 0) && (color[i - 1][1] == 0) && (color[i - 1][2] == 255)) color = setColor(color, i, (short)(step * -1), (short)0, (short)0);
        }

        return color;
    }
    public static short[][] setColor(short color[][], short i, short r, short g, short b){
        color[i][0] = colorValueCounting(color, i, 0, r);
        color[i][1] = colorValueCounting(color, i, 1, g);
        color[i][2] = colorValueCounting(color, i, 2, b);

        return color;
    }
    public static short colorValueCounting(short color[][], short i, int j, short value){
        if(i == 0) return  (short)(0 + value);
        else if((value >= 0) && (color[i-1][j] + value <= 255)) return  (short)(color[i-1][j] + value);
        else if((value >= 0) && (color[i-1][j] + value > 255)) return 255;
        else if((value < 0) && (color[i-1][j] + value >= 0)) return  (short)(color[i-1][j] + value);
        else if((value < 0) && (color[i-1][j] + value < 0)) return 0;
        else return 0;
    }

}

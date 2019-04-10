package mobile.example.com.testing;


import javax.microedition.khronos.opengles.GL10;

public class Center extends Entity {
    public Center(float ver[], float cols[]){
        super(ver, cols, new byte[]{0, 1, 2, 1, 2, 3});
        count = 6;
    }
    private Center(Colour colour, float ver[]){
        this(ver, GetColor(colour));
    }
    public void draw(GL10 gl){
        super.draw(gl);
    }
    public static float[] GetColor(float a, float b, float c){
        return new float[]{a, b, c, 0,
                a, b, c, 0,
                a, b, c, 0,
                a, b, c, 0,
        };
    }
    public static float[] GetColor(Colour colour){
        switch (colour){
            case RED:
                return GetColor(1, 0, 0);
            case BLUE:
                return GetColor(0, 0, 1);
            case WHITE:
                return GetColor(1, 1, 1);
            case YELLOW:
                return GetColor(1, 1, 0);
            case GREEN:
                return GetColor(0, 1, 0);
            case ORANGE:
                return GetColor(1, 0.5f, 0);
            case OO:
                return GetColor(0,0, 0);
            case OL:
                return GetColor(0.3f, 0.3f, 0.3f);
            case LO:
                return GetColor(0.6f, 0.6f, 0.6f);
            case LL:
                return GetColor(0.9f, 0.9f, 0.9f);
        }
        return null;
    }
    public static float[] GetPoint(float a, float b, int d){
        switch (d){
            case 0:
                return new float[]{a, b, b,
                        a, b, -b,
                        a, -b, b,
                        a, -b, -b,
                };
            case 1:
                return new float[]{b, a, b,
                        b, a, -b,
                        -b, a, b,
                        -b, a, -b,
                };
            case 2:
                return new float[]{b, b, a,
                        -b, b, a,
                        b, -b, a,
                        -b, -b, a,
                };
        }
        return null;
    }
    public static Center[] GetCenterArray(Square[][] input){
        Center[] ret = new Center[9];
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                ret[count] = new Center(input[i][j].Colour, input[i][j].Ver);
                count++;
            }
        }
        return ret;
    }
}

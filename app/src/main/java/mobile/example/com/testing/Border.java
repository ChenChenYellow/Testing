package mobile.example.com.testing;

public class Border extends Entity {
    public Border(float ver[], float cols[]){
        super(ver, cols, new byte[]{0, 1, 2, 1, 2, 3,
                                    4, 5, 6, 5, 6, 7});
        count = 12;
    }
    public static float[] GetColor(float a, float b, float c, float e, float f, float g){
        return new float[]{
                a,b,c,0,
                a,b,c,0,
                a,b,c,0,
                a,b,c,0,
                e,f,g,0,
                e,f,g,0,
                e,f,g,0,
                e,f,g,0,
        };
    }
    public static float[] GetPoint(float a, float c, int d){
        float b = -1;
        float temp = b;
        float temp2 = b;
        if(c > 0){
            temp = -b;
        }
        if(a > 0){
            temp2 = -b;
        }
        switch (d){
            case 0:
                return new float[]{
                        b, a, temp,
                        -b, a, temp,
                        b, a, c,
                        -b, a, c,
                        b, a, c,
                        -b, a, c,
                        b, temp2, c,
                        -b, temp2, c};

            case 1:
                return new float[]{
                        a, b, temp,
                        a, -b, temp,
                        a, b, c,
                        a, -b, c,
                        a, b, c,
                        a, -b, c,
                        temp2, b, c,
                        temp2, -b, c};

            case 2:
                return new float[]{
                        a, temp, b,
                        a, temp, -b,
                        a, c, b,
                        a, c, -b,
                        a, c, b,
                        a, c, -b,
                        temp2, c, b,
                        temp2, c, -b};

        }
        return null;
    }
}

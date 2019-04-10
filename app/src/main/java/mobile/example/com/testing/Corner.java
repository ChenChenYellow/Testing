package mobile.example.com.testing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.microedition.khronos.opengles.GL10;

public class Corner extends Entity {
    public Corner(float ver[], float cols[]){
        super(ver, cols, new byte[]{
                0, 1, 2,
                1, 2, 3,
                4, 5, 6,
                5, 6, 7,
                8, 9, 10,
                9, 10, 11
        });
        count = 18;
    }
    public static float[] GetPoint(float a, float b, float c){
        float tempX = 1,  tempY = 1, tempZ = 1;
        if (a < 0){
            tempX = -tempX;
        }
        if (b < 0){
            tempY = - tempY;
        }
        if (c <0){
            tempZ = -tempZ;
        }

        return new float[]{
                a, tempY, c,
                tempX, tempY, c,
                a, b, c,
                tempX, b, c,

                a, b, c,
                tempX, b, c,
                a, b, tempZ,
                tempX, b, tempZ,

                a, tempY, c,
                a, b, c,
                a, tempY, tempZ,
                a, b, tempZ
        };
    }
    public static  float[] GetColor(float a, float b, float c, float d, float e, float f, float g, float h, float i){
        return new float[]{
                a, b, c, 0,
                a, b, c, 0,
                a, b, c, 0,
                a, b, c, 0,
                d, e, f, 0,
                d, e, f, 0,
                d, e, f, 0,
                d, e, f, 0,
                g, h, i, 0,
                g, h, i, 0,
                g, h, i, 0,
                g, h, i, 0
        };
    }
}

package mobile.example.com.testing;

import java.util.concurrent.CountDownLatch;

public class Square{
    public Colour Colour;
    public float[] Ver;
    public Square(Colour colour, float[] ver){
        this.Colour = colour;
        this.Ver = ver;
    }
    public Square(Colour colour, float x1, float y1, float z1, float x2, float y2, float z2){
        this.Colour = colour;
        if (x1 == x2){
            this.Ver = new float[]{
                    x1, y1, z1,
                    x1, y2, z1,
                    x1, y1, z2,
                    x1, y2, z2
            };
        }else if (y1 == y2){
            this.Ver = new float[]{
                    x1, y1, z1,
                    x2, y1, z1,
                    x1, y1, z2,
                    x2, y1, z2
            };
        }else if (z1 == z2){
            this.Ver = new float[]{
                    x1, y1, z1,
                    x2, y1, z1,
                    x1, y2, z1,
                    x2, y2, z1
            };
        }

    }
}

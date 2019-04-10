package mobile.example.com.testing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cube {
    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer indexBuffer;

    public float vertices[] ={
            0, 0, 0, //0 000
            0, 0, 1,  //1 001
            0, 1, 0,  //2 010
            0, 1, 1,  //3 011
            1, 0, 0,  //4 100
            1, 0, 1,  //5 101
            1, 1, 0,  //6 110
            1, 1, 1  //7 111
    };
    public float colors[] = {
            1, 1, 0, 0,  //red // green // blue //000 black //111 white
            1, 1, 0, 0,
            1, 1, 0, 0,
            1, 0, 0, 1,
            1, 0, 0, 1,
            1, 0, 0, 1,
            1, 0, 0, 1,
            1, 0, 0, 1
    };
    public byte indices[] = {
            0, 1, 2, 1, 2, 3,
            7, 3, 5, 3, 5, 1,
            4, 5, 0, 5, 0, 1,
            6, 7, 2, 7, 2, 3,
            0, 2, 4, 2, 4, 6,
            5, 4, 7, 4, 7, 6
    };


    public Cube(){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        byteBuffer = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        colorBuffer = byteBuffer.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }
    public void draw(GL10 gl){
        gl.glFrontFace(GL10.GL_CW);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE,
                indexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}






























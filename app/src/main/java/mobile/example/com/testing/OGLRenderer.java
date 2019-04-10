package mobile.example.com.testing;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;
import android.opengl.Matrix;
import android.opengl.GLES20;

import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;

import javax.microedition.khronos.opengles.GL10;


public class OGLRenderer implements GLSurfaceView.Renderer {
    private Cube cube = new Cube();
    public static float cubeRotationX = 0;
    public static float cubeRotationY = 0;
    public static float cubeRotationZ = 0;
    public static float locX = 0;
    public static float locY = 0;
    public static float locZ = -30;
    public static float angle = 0f;
    private static OGLRenderer renderer = new OGLRenderer();

    public static OGLRenderer GetInstance(){
        return renderer;
    }
    private Rubik rubik = new Rubik();

    /*private final static float[] mAccumulatedRotation = new float[16];
    private final static float[] mCurrentRotation = new float[16];
    private final static float[] mModelMatrix = new float[16];
    private static float[] mProjectionMatrix = new float[16];*/
    public void TurnR(){
        rubik.TurnR();
    }
    public void TurnRI(){
        rubik.TurnRI();
    }
    public void TurnL(){
        rubik.TurnL();
    }
    public void TurnLI(){
        rubik.TurnLI();
    }
    public void TurnU(){
        rubik.TurnU();
    }
    public void TurnUI(){
        rubik.TurnUI();
    }
    public void TurnD(){
        rubik.TurnD();
    }
    public void TurnDI(){
        rubik.TurnDI();
    }
    public void TurnF(){
        rubik.TurnF();
    }
    public void TurnFI(){
        rubik.TurnFI();
    }
    public void TurnB(){rubik.TurnB(); }
    public void TurnBI(){rubik.TurnBI();}

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0, 0, 0, 0.5f);
        gl.glClearDepthf(1);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);
       /* Matrix.setIdentityM(mAccumulatedRotation, 0);*/

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45, (float)width/(float)height, 0.1f, 100);

        gl.glViewport(0,0,width, height);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

/*
        GLES20.glViewport(0, 0, width, height);
        final float ratio = (float) width / height;
        final float left = -ratio;
        final float right = ratio;
        final float bottom = -1.0f;
        final float top = 1.0f;
        final float near = 1.0f;
        final float far = 10.0f;
        Matrix.frustumM(mProjectionMatrix, 0, left, right, bottom, top, near, far);

    */}




    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(locX,locY,locZ);
        //gl.glRotatef(angle, cubeRotationX ,cubeRotationY, cubeRotationZ);
        gl.glRotatef(cubeRotationX, 1, 0, 0);
        gl.glRotatef(cubeRotationY, 0, 1, 0);
        gl.glRotatef(cubeRotationZ, 0, 0, 1);

        rubik.draw(gl);
        //cube.draw(gl);
        gl.glLoadIdentity();
        /*GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        Matrix.setIdentityM(mModelMatrix, 0);
        rubik.draw(gl);*/
    }
}


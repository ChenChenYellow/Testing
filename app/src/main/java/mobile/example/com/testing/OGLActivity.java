package mobile.example.com.testing;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OGLActivity extends Activity {
    private int yDelta;
    private int xDelta;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        GLSurfaceView view = new GLSurfaceView(this);
        final OGLRenderer renderer =  new OGLRenderer();
        view.setRenderer(renderer);
        setContentView(view);


    }
}

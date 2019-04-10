package mobile.example.com.testing;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.opengl.GLSurfaceView;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int xDelta, yDelta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));



        LinearLayout linLay = findViewById(R.id.LinLay);


        GLSurfaceView view = new GLSurfaceView(this);

        view.setRenderer(OGLRenderer.GetInstance());

        //Log.w("myErr", "TTT2");

        findViewById(R.id.buttonUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locY += 1;
            }
        });
        findViewById(R.id.buttonDown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locY-=1;
            }
        });
        findViewById(R.id.buttonLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locX -= 1;
            }
        });
        findViewById(R.id.buttonRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locX +=1;
            }
        });
        findViewById(R.id.buttonForward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locZ -= 1;
            }
        });
        findViewById(R.id.buttonBackward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().locZ +=1;
            }
        });

        /*
        findViewById(R.id.buttonXPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.cubeRotationX = Math.round((OGLRenderer.GetInstance().cubeRotationX / 90) + 1) * 90;
                OGLRenderer.cubeRotationX += 1;
                Auto.Log();
            }
        });


        findViewById(R.id.buttonXMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.cubeRotationX = Math.round((OGLRenderer.GetInstance().cubeRotationX / 90) - 1) * 90;
                OGLRenderer.cubeRotationX -= 1;
                Auto.Log();
            }
        });

        findViewById(R.id.buttonYPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.cubeRotationY = Math.round((OGLRenderer.GetInstance().cubeRotationY / 90) + 1) * 90;
                OGLRenderer.cubeRotationY += 1;
                Auto.Log();
            }
        });
        findViewById(R.id.buttonYMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.GetInstance().cubeRotationY = Math.round((OGLRenderer.GetInstance().cubeRotationY / 90) - 1) * 90;
                OGLRenderer.cubeRotationY -= 1;
                Auto.Log();
            }
        });

        findViewById(R.id.buttonZPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.GetInstance().cubeRotationZ = Math.round((OGLRenderer.GetInstance().cubeRotationZ / 90) + 1) * 90;
                OGLRenderer.cubeRotationZ += 1;
                Auto.Log();
            }
        });
        findViewById(R.id.buttonZMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OGLRenderer.GetInstance().cubeRotationZ = Math.round((OGLRenderer.GetInstance().cubeRotationZ / 90) - 1) * 90;
                OGLRenderer.cubeRotationZ -= 1;
                Auto.Log();
            }
        });
*/


        findViewById(R.id.buttonXPlus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationX += 1;
                Auto.Log();
                return false;
            }
        });
        findViewById(R.id.buttonXMinus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationX -= 1;
                Auto.Log();
                return false;
            }
        });

        findViewById(R.id.buttonYPlus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationY += 1;
                Auto.Log();
                return false;
            }
        });
        findViewById(R.id.buttonYMinus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationY -= 1;
                Auto.Log();
                return false;
            }
        });

        findViewById(R.id.buttonZPlus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationZ += 1;
                Auto.Log();
                return false;
            }
        });
        findViewById(R.id.buttonZMinus).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OGLRenderer.cubeRotationZ -= 1;
                Auto.Log();
                return false;
            }
        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {final int x = (int)event.getRawX();
                final int y = (int)event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        yDelta = y;
                        xDelta = x;
                        break;
                    case MotionEvent.ACTION_MOVE:

                        int fX = (int)event.getRawX() - xDelta;
                        int fY = (int)event.getRawY()- yDelta;
                        yDelta = y;
                        xDelta = x;
                        Auto.DirectionMovement(fX, fY);
                        break;

                }
                return  true;
            }
        });

        findViewById(R.id.buttonR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnR();
            }
        });
        findViewById(R.id.buttonRI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnRI();
            }
        });
        findViewById(R.id.buttonL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnL();
            }
        });
        findViewById(R.id.buttonLI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnLI();
            }
        });
        findViewById(R.id.buttonU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnU();
            }
        });
        findViewById(R.id.buttonUI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnUI();
            }
        });
        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnD();
            }
        });
        findViewById(R.id.buttonDI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnDI();
            }
        });
        findViewById(R.id.buttonF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnF();
            }
        });
        findViewById(R.id.buttonFI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnFI();
            }
        });

        findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnB();
            }
        });
        findViewById(R.id.buttonBI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OGLRenderer.GetInstance().TurnBI();
            }
        });

        linLay.addView(view);

    }
}

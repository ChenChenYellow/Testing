package mobile.example.com.testing;

import android.util.Log;

import javax.microedition.khronos.opengles.GL10;

public class Rubik {
    /*
    private Center whiteCenter = new Center(Center.GetPoint(-3, 1, 0),Center.GetColor(1, 1,1));
    private Center yellowCenter = new Center(Center.GetPoint(3, 1, 0),Center.GetColor(1, 1,0));
    private Center redCenter = new Center(Center.GetPoint(-3, 1, 2),Center.GetColor(1, 0,0));
    private Center blueCenter = new Center(Center.GetPoint(3, 1, 2),Center.GetColor(0, 0,1));
    private Center greenCenter = new Center(Center.GetPoint(-3, 1, 1),Center.GetColor(0, 1,0));
    private Center orangeCenter = new Center(Center.GetPoint(3, 1, 1),Center.GetColor(1, 0.5f,0));
    private Border borderWR = new Border(Border.GetPoint(-3, -3, 1), Border.GetColor(1, 1, 1, 1, 0, 0 ));
    private Border borderWB = new Border(Border.GetPoint(-3, 3, 1), Border.GetColor(1, 1, 1,  0, 0, 1));
    private Border borderWG = new Border(Border.GetPoint(-3, -3, 2), Border.GetColor(1, 1, 1,  0, 1, 0));
    private Border borderWO = new Border(Border.GetPoint(-3, 3, 2), Border.GetColor(1, 1, 1,  1, 0.5f, 0));
    private Border borderYR = new Border(Border.GetPoint(3, -3, 1), Border.GetColor(1, 1, 0, 1, 0, 0));
    private Border borderYB = new Border(Border.GetPoint(3, 3, 1), Border.GetColor(1, 1, 0,  0, 0, 1));
    private Border borderYG = new Border(Border.GetPoint(3, -3, 2), Border.GetColor(1, 1, 0,  0, 1, 0));
    private Border borderYO = new Border(Border.GetPoint(3, 3, 2), Border.GetColor(1, 1, 0, 1, 0.5f, 0));
    private Border borderGR = new Border(Border.GetPoint(-3, -3, 0), Border.GetColor(0, 1, 0, 1, 0, 0));
    private Border borderRO = new Border(Border.GetPoint(3, -3, 0), Border.GetColor(1, 0.5f, 0, 1, 0, 0));
    private Border borderOB = new Border(Border.GetPoint(3, 3, 0), Border.GetColor(1, 0.5f, 0, 0, 0, 1));
    private Border borderBG = new Border(Border.GetPoint(-3, 3, 0), Border.GetColor(0, 1, 0, 0, 0, 1));
    private Corner cornerWBO = new Corner(Corner.GetPoint(-3, 3, 3), Corner.GetColor(0, 0, 1, 1,0.5f,0,1,1,1));
    private Corner cornerWBG = new Corner(Corner.GetPoint(-3, -3, 3), Corner.GetColor(0, 0, 1, 0,1,0,1,1,1));
    private Corner cornerWRG = new Corner(Corner.GetPoint(-3, -3, -3), Corner.GetColor(1, 0, 0, 0,1,0,1,1,1));
    private Corner cornerWRO = new Corner(Corner.GetPoint(-3, 3, -3), Corner.GetColor(1, 0, 0, 1,0.5f,0,1,1,1));
    private Corner cornerYBO = new Corner(Corner.GetPoint(3, 3, 3), Corner.GetColor(0, 0, 1, 1,0.5f,0,1,1,0));
    private Corner cornerYBG = new Corner(Corner.GetPoint(3, -3, 3), Corner.GetColor(0, 0, 1, 0,1,0,1,1,0));
    private Corner cornerYRG = new Corner(Corner.GetPoint(3, -3, -3), Corner.GetColor(1, 0, 0, 0,1,0,1,1,0));
    private Corner cornerYRO = new Corner(Corner.GetPoint(3, 3, -3), Corner.GetColor(1, 0, 0, 1,0.5f,0,1,1,0));

    public Entity blocks[] = {*/
            /*borderWB,
            borderWR,
            borderWG,
            borderWO,
            borderYB,
            borderYR,
            borderYG,
            borderYO,
            borderGR,
            borderRO,
            borderOB,
            borderBG,
            redCenter,
            blueCenter,
            greenCenter,
            whiteCenter,
            yellowCenter,
            orangeCenter,
            cornerWBO,
            cornerWBG,
            cornerWRG,
            cornerWRO,
            cornerYBO,
            cornerYBG,
            cornerYRG,
            cornerYRO*/
   /* };*/

    private Square[][] redSquare = arrayInit(Colour.RED, true, Direction.X);
    private Square[][] whiteSquare = arrayInit(Colour.WHITE, true, Direction.Y);
    private Square[][] orangeSquare = arrayInit(Colour.ORANGE, true, Direction.Z);
    private Square[][] blueSquare = arrayInit(Colour.BLUE, false, Direction.X);
    private Square[][] yellowSquare = arrayInit(Colour.YELLOW, false, Direction.Y);
    private Square[][] greenSquare = arrayInit(Colour.GREEN, false, Direction.Z);
    private void turn(Square[][] a, Square[][] b, Square[][] c, Square[][] d, int x1, int x2, int y1, int y2, int x0, int y0){
        Colour temp1 = a[x0][y0].Colour;
        Colour temp2 = a[x1][y1].Colour;
        Colour temp3 = a[x2][y2].Colour;

        a[x0][y0].Colour = b[x0][y0].Colour;
        a[x1][y1].Colour= b[x1][y1].Colour;
        a[x2][y2].Colour = b[x2][y2].Colour;

        b[x0][y0].Colour = c[x2][y2].Colour;
        b[x1][y1].Colour= c[x1][y1].Colour;
        b[x2][y2].Colour = c[x0][y0].Colour;

        c[x0][y0].Colour = d[x0][y0].Colour ;
        c[x1][y1].Colour= d[x1][y1].Colour ;
        c[x2][y2].Colour = d[x2][y2].Colour ;

        d[x2][y2].Colour = temp1;
        d[x1][y1].Colour = temp2;
        d[x0][y0].Colour = temp3;
    }
    private void turn(Square[][] a, Square[][] b, Square[][] c, Square[][] d, boolean clock, boolean left, boolean onX){
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int x0 = 0;
        int y0 = 0;
        if (onX){
            x1 = 1;
            x2 = 2;
            if (!left){
                y0 = 2;
                y1 = 2;
                y2 = 2;
            }
        }else{
            y1 = 1;
            y2 = 2;
            if (!left){
                x0 = 2;
                x2 = 2;
                x1 = 2;
            }
        }
        if (clock){
            turn(a, b, c, d, x1, x2, y1, y2, x0, y0);



        }else{
            turn(d, c, b, a, x1, x2, y1, y2, x0, y0);
        }
    }
    private void roll(Square[][] e, boolean clock){

        if (!clock){
            Colour temp1 = e[0][0].Colour;
            Colour temp2 = e[0][1].Colour;

            e[0][0].Colour = e[0][2].Colour;
            e[0][1].Colour = e[1][2].Colour;

            e[0][2].Colour = e[2][2].Colour;
            e[1][2].Colour = e[2][1].Colour;

            e[2][2].Colour = e[2][0].Colour;
            e[2][1].Colour = e[1][0].Colour;

            e[2][0].Colour = temp1;
            e[1][0].Colour = temp2;
        }else{
            Colour temp1 = e[2][0].Colour;
            Colour temp2 = e[1][0].Colour;

            e[2][0].Colour = e[2][2].Colour;
            e[1][0].Colour = e[2][1].Colour;

            e[2][2].Colour = e[0][2].Colour;
            e[2][1].Colour = e[1][2].Colour;

            e[0][2].Colour = e[0][0].Colour;
            e[1][2].Colour = e[0][1].Colour;

            e[0][0].Colour = temp1;
            e[0][1].Colour = temp2;
        }
    }
    public void TurnR(){
        turn(blueSquare, whiteSquare, redSquare, yellowSquare, true, true, true);
        roll(greenSquare, false);
    }
    public void TurnRI(){
        turn(blueSquare, whiteSquare, redSquare, yellowSquare, false, true, true);
        roll(greenSquare, true);
    }
    public void TurnL(){
        turn(blueSquare, whiteSquare, redSquare, yellowSquare, true, false, true);
        roll(orangeSquare, false);
    }
    public void TurnLI(){
        turn(blueSquare, whiteSquare, redSquare, yellowSquare, false, false, true);
        roll(orangeSquare, true);
    }
    public void TurnU(){
        turnU(orangeSquare, redSquare, greenSquare, blueSquare);
        roll(yellowSquare, false);
    }
    private void turnU(Square[][] a,Square[][] b,Square[][] c,Square[][] d){
        Colour temp1 = a[0][0].Colour;
        Colour temp2 = a[1][0].Colour;
        Colour temp3 = a[2][0].Colour;

        a[0][0].Colour = b[0][2].Colour;
        a[1][0].Colour = b[0][1].Colour;
        a[2][0].Colour = b[0][0].Colour;

        b[0][2].Colour = c[2][0].Colour;
        b[0][1].Colour = c[1][0].Colour;
        b[0][0].Colour = c[0][0].Colour;

        c[2][0].Colour = d[0][0].Colour;
        c[1][0].Colour = d[0][1].Colour;
        c[0][0].Colour = d[0][2].Colour;

        d[0][0].Colour = temp1;
        d[0][1].Colour = temp2;
        d[0][2].Colour = temp3;
    }
    public void TurnUI(){
        turnUI(orangeSquare, redSquare, greenSquare, blueSquare);
        roll(yellowSquare, true);
    }
    private void turnUI(Square[][] a,Square[][] b,Square[][] c,Square[][] d){

        Colour temp1 = d[0][0].Colour;
        Colour temp2 = d[0][1].Colour;
        Colour temp3 = d[0][2].Colour;

        d[0][0].Colour = c[2][0].Colour;
        d[0][1].Colour = c[1][0].Colour;
        d[0][2].Colour = c[0][0].Colour;

        c[2][0].Colour = b[0][2].Colour;
        c[1][0].Colour = b[0][1].Colour;
        c[0][0].Colour = b[0][0].Colour ;

        b[0][2].Colour = a[0][0].Colour;
        b[0][1].Colour = a[1][0].Colour;
        b[0][0].Colour = a[2][0].Colour;

        a[0][0].Colour = temp1;
        a[1][0].Colour = temp2;
        a[2][0].Colour = temp3;
    }
    private void turnD(Square[][] a, Square[][] b, Square[][] c, Square[][] d){
        Colour temp1 = a[0][2].Colour;
        Colour temp2 = a[1][2].Colour;
        Colour temp3 = a[2][2].Colour;

        a[0][2].Colour = b[2][2].Colour;
        a[1][2].Colour = b[2][1].Colour;
        a[2][2].Colour = b[2][0].Colour;

        b[2][2].Colour = c[2][2].Colour;
        b[2][1].Colour = c[1][2].Colour;
        b[2][0].Colour = c[0][2].Colour;

        c[2][2].Colour = d[2][0].Colour;
        c[1][2].Colour = d[2][1].Colour;
        c[0][2].Colour = d[2][2].Colour;

        d[2][0].Colour = temp1;
        d[2][1].Colour = temp2;
        d[2][2].Colour = temp3;
    }
    private void turnDI(Square[][] a,Square[][] b,Square[][] c,Square[][] d){

        Colour temp1 = d[2][0].Colour;
        Colour temp2 = d[2][1].Colour;
        Colour temp3 = d[2][2].Colour;

        d[2][0].Colour = c[2][2].Colour;
        d[2][1].Colour = c[1][2].Colour;
        d[2][2].Colour = c[0][2].Colour;

        c[2][2].Colour = b[2][2].Colour;
        c[1][2].Colour = b[2][1].Colour;
        c[0][2].Colour = b[2][0].Colour ;

        b[2][2].Colour = a[0][2].Colour;
        b[2][1].Colour = a[1][2].Colour;
        b[2][0].Colour = a[2][2].Colour;

        a[0][2].Colour = temp1;
        a[1][2].Colour = temp2;
        a[2][2].Colour = temp3;
    }
    public void TurnD(){
        turnD(orangeSquare, redSquare, greenSquare, blueSquare);
        roll(whiteSquare, false);
    }
    public void TurnDI(){
        turnDI(orangeSquare, redSquare, greenSquare, blueSquare);
        roll(whiteSquare, true);
    }
    private void turnF(Square[][] a,Square[][] b,Square[][] c,Square[][] d){
        Colour temp1 = a[2][2].Colour;
        Colour temp2 = a[1][2].Colour;
        Colour temp3 = a[0][2].Colour;

        a[2][2].Colour = b[2][2].Colour;
        a[1][2].Colour = b[1][2].Colour;
        a[0][2].Colour = b[0][2].Colour;

        b[2][2].Colour = c[0][2].Colour;
        b[1][2].Colour = c[1][2].Colour;
        b[0][2].Colour = c[2][2].Colour;

        c[0][2].Colour = d[0][2].Colour;
        c[1][2].Colour = d[1][2].Colour;
        c[2][2].Colour = d[2][2].Colour;

        d[0][2].Colour = temp1;
        d[1][2].Colour = temp2;
        d[2][2].Colour = temp3;
    }
    public void TurnF(){
        turnF(redSquare, yellowSquare, blueSquare, whiteSquare);
        roll(orangeSquare, false);
    }
    private void turnFI(Square[][] a,Square[][] b,Square[][] c,Square[][] d){
        Colour temp1 = d[0][2].Colour;
        Colour temp2 = d[1][2].Colour;
        Colour temp3 = d[2][2].Colour;

        d[0][2].Colour = c[0][2].Colour;
        d[1][2].Colour = c[1][2].Colour;
        d[2][2].Colour = c[2][2].Colour;

        c[0][2].Colour = b[2][2].Colour;
        c[1][2].Colour = b[1][2].Colour;
        c[2][2].Colour = b[0][2].Colour;

        b[2][2].Colour = a[2][2].Colour;
        b[1][2].Colour = a[1][2].Colour;
        b[0][2].Colour = a[0][2].Colour;

        a[2][2].Colour = temp1;
        a[1][2].Colour = temp2;
        a[0][2].Colour = temp3;
    }
    public void TurnFI(){
        turnFI(redSquare, yellowSquare, blueSquare, whiteSquare);
        roll(orangeSquare, true);
    }
    private void turnB(Square[][] a,Square[][] b,Square[][] c,Square[][] d){
        Colour temp1 = a[2][0].Colour;
        Colour temp2 = a[1][0].Colour;
        Colour temp3 = a[0][0].Colour;

        a[2][0].Colour = b[2][0].Colour;
        a[1][0].Colour = b[1][0].Colour;
        a[0][0].Colour = b[0][0].Colour;

        b[2][0].Colour = c[0][0].Colour;
        b[1][0].Colour = c[1][0].Colour;
        b[0][0].Colour = c[2][0].Colour;

        c[0][0].Colour = d[0][0].Colour;
        c[1][0].Colour = d[1][0].Colour;
        c[2][0].Colour = d[2][0].Colour;

        d[0][0].Colour = temp1;
        d[1][0].Colour = temp2;
        d[2][0].Colour = temp3;
    }
    public void TurnB(){
        turnB(redSquare, yellowSquare, blueSquare, whiteSquare);
        roll(greenSquare, false);
    }
    private void turnBI(Square[][] a,Square[][] b,Square[][] c,Square[][] d){
        Colour temp1 = d[0][0].Colour;
        Colour temp2 = d[1][0].Colour;
        Colour temp3 = d[2][0].Colour;

        d[0][0].Colour = c[0][0].Colour;
        d[1][0].Colour = c[1][0].Colour;
        d[2][0].Colour = c[2][0].Colour;

        c[0][0].Colour = b[2][0].Colour;
        c[1][0].Colour = b[1][0].Colour;
        c[2][0].Colour = b[0][0].Colour;

        b[2][0].Colour = a[2][0].Colour;
        b[1][0].Colour = a[1][0].Colour;
        b[0][0].Colour = a[0][0].Colour;

        a[2][0].Colour = temp1;
        a[1][0].Colour = temp2;
        a[0][0].Colour = temp3;
    }
    public void TurnBI(){
        turnBI(redSquare, yellowSquare, blueSquare, whiteSquare);
        roll(greenSquare, true);
    }
    private static Square[][] arrayInit(Colour c, boolean positive, Direction dir){
        Square[][] ret = new Square[3][3];
        float three = 3;

        if (!positive){
            three = -3;
        }
        switch (dir){
            case X:
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j++){
                        ret[i][j] = new Square(c, three, -3 + (i * 2), -3 + (j *2), three, -1 + (i * 2), -1 + (j *2));
                    }
                }

                break;
            case Y:
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j++){
                        ret[i][j] = new Square(c, -3 + (i * 2), three, -3 + (j *2), -1 + (i * 2), three, -1 + (j *2));
                    }
                }
                break;
            case Z:
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j++){
                        ret[i][j] = new Square(c, -3 + (i * 2), -3 + (j *2), three, -1 + (i * 2), -1 + (j *2), three);
                    }
                }
                break;
        }
        ret[0][0].Colour = Colour.OO;
        ret[0][2].Colour = Colour.OL;
        ret[2][0].Colour = Colour.LO;
        ret[2][2].Colour = Colour.LL;
        return ret;
    }
    public void draw(GL10 gl) {
        //Log.w("myErr", "DRAW");

        Center[] ret1 = Center.GetCenterArray(redSquare);
        Center[] ret2 = Center.GetCenterArray(whiteSquare);
        Center[] ret3 = Center.GetCenterArray(orangeSquare);
        Center[] ret4 = Center.GetCenterArray(blueSquare);
        Center[] ret5 = Center.GetCenterArray(yellowSquare);
        Center[] ret6 = Center.GetCenterArray(greenSquare);
        for (int i = 0; i < 9; i++){
            ret1[i].draw(gl);
            ret2[i].draw(gl);
            ret3[i].draw(gl);
            ret4[i].draw(gl);
            ret5[i].draw(gl);
            ret6[i].draw(gl);
        }
        /*for (int i = 0; i < blocks.length; i++){
            blocks[i].draw(gl);
        }*/
    }


}

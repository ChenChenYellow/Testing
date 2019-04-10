package mobile.example.com.testing;

import android.util.Log;

public class Auto {
    public static void ViewpointScanMovement(float rx, float ry, float rz, OGLRenderer renderer, float fx, float fy){

    }
    public static void DirectionMovement(float fX, float fY){
        DirectionMovement(parseTo(OGLRenderer.cubeRotationX), parseTo(OGLRenderer.cubeRotationY), parseTo(OGLRenderer.cubeRotationZ), fX, fY);
    }
    private static int parseTo(float i){
        if (i < 45 || i >= 315){
            return 0;
        }else if(i >= 45 && i < 135){
            return 1;
        }else if(i >= 135 && i < 225){
            return 2;
        }else{
            return 3;
        }
    }
    public static void Log(){
        Log.e("myErr", String.valueOf(parseTo(OGLRenderer.GetInstance().cubeRotationX)) + " " + String.valueOf(parseTo(OGLRenderer.GetInstance().cubeRotationY)) + " " + String.valueOf(parseTo(OGLRenderer.GetInstance().cubeRotationZ)));
    }
    public static void LogS(){
        Log.e("myErr", String.valueOf(OGLRenderer.GetInstance().cubeRotationX) + " " + String.valueOf(OGLRenderer.GetInstance().cubeRotationY) + " " + String.valueOf(OGLRenderer.GetInstance().cubeRotationZ));
    }
    private static void cubeRotate (float X, float Y, float Z){
        OGLRenderer.cubeRotationX += X * 0.5;
        OGLRenderer.cubeRotationY += Y * 0.5;
        OGLRenderer.cubeRotationZ += Z * 0.5;
    }
    private static void DirectionMovement(int rx, int ry, int rz, float fX, float fY){
        Log.e("myErr", String.valueOf(rx) + " " + String.valueOf(ry) + " " + String.valueOf(rz));
        if(rx == 0){


            if(ry == 0){
                if(rz == 0){
                    cubeRotate( fY, fX, 0);
                }else if(rz == 1){
                    cubeRotate( fY, fX,0);
                }else if(rz == 2){
                    cubeRotate( fY, fX,0);
                }else{
                    cubeRotate( fY, fX,0);
                }
            }else if(ry == 1){
                if(rz == 0){
                    cubeRotate( fY, fX,0);
                }else if(rz == 1){
                    cubeRotate( fY, fX,0);
                }else if(rz == 2){
                    cubeRotate( fY, fX,0);
                }else {
                    cubeRotate(fY, fX,0);
                }
            }else if(ry == 2){
                if(rz == 0){
                    cubeRotate( fY, fX,0);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else{
                if(rz == 0){
                    cubeRotate( fY, fX,0);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }


        }else if(rx == 1){
            if(ry == 0){
                if(rz == 0){
                    cubeRotate( fY, 0,-fX);
                }else if(rz == 1){
                    cubeRotate( fY, 0,-fX);
                }else if(rz == 2){
                    cubeRotate( fY, 0,-fX);
                }else {
                    cubeRotate( fY, 0,-fX);
                }
            }else if(ry == 1) {
                if(rz == 0){
                    cubeRotate( fY, fX,0);
                    Log.e("myErr", "X " + String.valueOf(fX));
                    Log.e("myErr", "Y " + String.valueOf(fY));
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else if(ry == 2) {
                if(rz == 0){

                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else{
                if(rz == 0){
                    //cubeRotate(renderer, fY, 0,-fX);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }


        }else if(rx == 2){
            if(ry == 0){
                if(rz == 0){
                    cubeRotate( fY, -fX,0);
                }else if(rz == 1){
                    cubeRotate( fY, -fX,0);
                }else if(rz == 2){
                    cubeRotate( fY, -fX,0);
                }else {
                    cubeRotate( fY, -fX,0);
                }
            }else if(ry == 1) {
                if(rz == 0){
                    cubeRotate( fY, -fX,0);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else if(ry == 2) {
                if(rz == 0){
                    cubeRotate( fY, -fX,0);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else{
                if(rz == 0){
                    cubeRotate( fY, -fX,0);
                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }


        }else {
            if(ry == 0){
                if(rz == 0){
                    cubeRotate( fY, 0,fX);
                }else if(rz == 1){
                    cubeRotate( fY, 0,fX);
                }else if(rz == 2){
                    cubeRotate( fY, 0,fX);
                }else {
                    cubeRotate( fY, 0,fX);
                }
            }else if(ry == 1) {
                if(rz == 0){

                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else if(ry == 2) {
                if(rz == 0){

                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }else{
                if(rz == 0){

                }else if(rz == 1){

                }else if(rz == 2){

                }else {

                }
            }
        }
    }
}

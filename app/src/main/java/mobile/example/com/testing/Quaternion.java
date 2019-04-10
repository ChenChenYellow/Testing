package mobile.example.com.testing;

public final class Quaternion {
    private double x, y, z, w;
    public void set(final Quaternion q){
        this.w = q.w;
        this.x = q.x;
        this.y = q.y;
        this.z = q.z;
    }
}

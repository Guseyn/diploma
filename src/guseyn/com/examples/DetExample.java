package guseyn.com.examples;

import guseyn.com.libs.QMatrix;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

public class DetExample {

    public static void main(String[] args) throws Exception {
        Quaternion[] a = new Quaternion[]{
                new Quaternion(11, new Vector(0, 0, 0)),
                new Quaternion(13, new Vector(31, 4, 4)),
                new Quaternion(15, new Vector(1, 61, 6)),
                new Quaternion(17, new Vector(7, 8, 81))
        };
        System.out.println(QMatrix.getDeterminant(a));
    }
}

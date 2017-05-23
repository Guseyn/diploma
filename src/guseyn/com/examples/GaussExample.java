package guseyn.com.examples;

import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;
import guseyn.com.methods.Gauss;

public class GaussExample {

    public static void main(String[] args) throws Exception {
        Quaternion[] a = new Quaternion[]{
                new Quaternion(1.000067658797585676, new Vector(4.547474574575, 0.4574574574, 0.4574574574574571)),
                new Quaternion(3.4564573426434868457346235, new Vector(0.4575474584576341, 0, 2.437762535445654)),
                new Quaternion(0.346577668457469, new Vector(-2.354864573462359, 3.4364754657687604, 2.3462316245465346227)),
                new Quaternion(6.437548658761, new Vector(6.565785674366987, -4.63547676986765343, 5.34756576697685476533))
        };
        Quaternion b = new Quaternion(9, new Vector(12, 23, 11));
        Quaternion solution = new Gauss(a, b).solve();
        System.out.println(Gauss.checkB(a, solution));
    }

}

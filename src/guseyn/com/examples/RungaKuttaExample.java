package guseyn.com.examples;

import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;
import guseyn.com.interfaces.OrientationFunction;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;
import guseyn.com.methods.RungeKutta;

import java.util.HashMap;

public class RungaKuttaExample {

    public static Quaternion analyticalSolution(Double t) {
        return new Quaternion(1.5 - 0.5 * Math.cos(t),
                new Vector(1.5 - 0.5 * Math.cos(t), 1.5 - 0.5 * Math.cos(t), 1.5 - 0.5 * Math.cos(t)));
    }

    public static void printDiff(Quaternion q1, Quaternion q2) throws SizeException {
        System.out.println(q1.minus(q2).toString());
    }

    public static void main(String[] args) throws Exception {

        Quaternion lambda0 = new Quaternion(1, new Vector(1, 1, 1));
        OrientationFunction f = new OrientationFunction<Double, Quaternion, Quaternion>() {
            @Override
            public Quaternion apply(Double t, Quaternion lambda) throws SizeException, MultiplySideException {
                return new Quaternion(0.5 * Math.sin(t),
                        new Vector(0.5 * Math.sin(t), 0.5 * Math.sin(t), 0.5 * Math.sin(t)));
            }
        };

        double h = 0.01;
        double a = 0;
        double b = 100;
        HashMap result = new RungeKutta(a, b, h).solve(lambda0, f);
        int c = (int) (Math.abs(a-b)/h);
        Quaternion[] solution = (Quaternion[]) result.get("quaternion");

        for (int i = 0; i < c; i++) {
            printDiff(solution[i], analyticalSolution(i * h));
        }

    }


}

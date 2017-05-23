package guseyn.com.examples;

import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;
import guseyn.com.methods.RungeKuttaSpecific;

import java.util.HashMap;

public class RungaKuttaSpecificExample {

    public static void main(String[] args) throws Exception {

        Quaternion psi_t0 = new Quaternion(101796.4178628062,
                new Vector(-19010.42859404896, -112019.7633111641, 85304.9846376304));//начальное psi

        final double leftEdgeOfSegment = 0;
        final double rightEdgeOfSegment = 300;
        final double step = 0.001;

        final Quaternion lambdaQuaternion = new Quaternion(-0.58213,
                new Vector(0.10822, 0.641196, -0.48815)).normalize();
        final Double[] alpha = new Double[]{1000.0, 2000.0, 3000.0};

        final RungeKuttaSpecific rungeKuttaSpecific = new RungeKuttaSpecific(leftEdgeOfSegment,
                rightEdgeOfSegment, step, lambdaQuaternion, alpha);
        HashMap result = rungeKuttaSpecific.solve(psi_t0);
        Quaternion[] lambda = (Quaternion[]) result.get("lambda");
        Quaternion[] psi = (Quaternion[]) result.get("psi");
        Quaternion[] omega = (Quaternion[]) result.get("omega");

        for (int i = 0; i < lambda.length; i++ ) {
            System.out.println("norm of lambda: " +
                    lambda[i].getNorm() + ", norm of psi: " + psi[i].getNorm()
                    + ", norm of omega: " + omega[i].getNorm());
        }

    }


}

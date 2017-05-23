package guseyn.com.main;

import guseyn.com.exceptions.*;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.io.IOException;

public class BA extends Main {

    private static void ba(double time, Double[] a, Quaternion appr) throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        lambda_t0 = Quaternion.getFromEulerAngles(-78.40297589222291, -39.85579029209612, 112.90956966753056)
                .multiplyWithScalar(-1).normalize();
        System.out.println(Main.lambda_t0);
        lambda_T = new Quaternion(1, new Vector(0, 0, 0));
        leftEdgeOfSegment = 0.0;
        rightEdgeOfSegment = time;
        step = 0.001;
        alpha = a;
        approximation = appr;
        e = Math.pow(10, -9);
        solve();
    }

    public static void t300() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        ba(300.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(101796.4177557,
                new Vector(-19010.4286588, -112019.763395, 85304.98463593)));
        /*143.0483289121585*/
    }


    public static void t301() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        ba(301.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(101798.05361853,
                new Vector(-19010.4466412268, -112021.915567071, 85306.546601942)));
        /*142.5730831794837*/

    }

    public static void t302() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        ba(302.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(101831.48480477043,
                new Vector(-19016.377378804522, -112059.08686201072, 85334.76954226804)));
        /*142.10098482727184*/
    }


}

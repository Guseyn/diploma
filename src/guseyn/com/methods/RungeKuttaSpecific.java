package guseyn.com.methods;

import guseyn.com.exceptions.IndexException;
import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;
import guseyn.com.exceptions.ZeroException;
import guseyn.com.interfaces.OrientationFunction;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.util.HashMap;

public class RungeKuttaSpecific extends RungeKutta {

    protected Quaternion lambdaQuaternion;
    protected Double[] alpha;

    public RungeKuttaSpecific(double leftEdgeOfSegment,
                              double rightEdgeOfSegment,
                              double step,
                              Quaternion lambdaQuaternion,
                              Double[] alpha) {
        super(leftEdgeOfSegment, rightEdgeOfSegment, step);
        this.lambdaQuaternion = new Quaternion(lambdaQuaternion);
        this.alpha = alpha;
    }

    public HashMap solve(Quaternion psiQuaternion) throws ZeroException,
            MultiplySideException,
            SizeException, IndexException {

        if (step == 0) {
            throw new ZeroException("step is 0");
        }

        int quantityOfIntervals =
                (int) ((rightEdgeOfSegment - leftEdgeOfSegment) / step);

        HashMap<String, Quaternion[]> result = new HashMap<String, Quaternion[]>();
        Quaternion[] lambdaResult = new Quaternion[quantityOfIntervals];
        Quaternion[] psiResult = new Quaternion[quantityOfIntervals];
        Quaternion[] omegaResult = new Quaternion[quantityOfIntervals];
        double[] time = new double[quantityOfIntervals];

        time[0] = leftEdgeOfSegment;
        lambdaResult[0] = new Quaternion(lambdaQuaternion);
        psiResult[0] = new Quaternion(psiQuaternion);
        omegaResult[0] = new Quaternion(getOmegaOptimal(lambdaResult[0], psiResult[0], alpha));

        for (int i = 1; i < quantityOfIntervals; i++) {
            HashMap next = getNextInSpecificRungeKutta(time[i - 1],
                    lambdaResult[i - 1], psiResult[i - 1], omegaResult[i - 1]);
            time[i] = (Double) next.get("time");
            lambdaResult[i] = new Quaternion((Quaternion) next.get("lambda"));
            psiResult[i] = new Quaternion((Quaternion) next.get("psi"));
            omegaResult[i] = new Quaternion((Quaternion) next.get("omega"));
        }

        result.put("lambda", lambdaResult);
        result.put("psi", psiResult);
        result.put("omega", omegaResult);
        return result;
    }

    protected HashMap<String, Object> getNextInSpecificRungeKutta(Double time,
                                                                  final Quaternion lambdaQuaternion,
                                                                  Quaternion psiQuaternion,
                                                                  final Quaternion omegaOptimalQuaternion) throws MultiplySideException, SizeException, IndexException {

        HashMap<String, Object> result = new HashMap<String, Object>();

        Quaternion newLambdaQuaternion = new Quaternion((Quaternion) getNextInRungeKutta(time, lambdaQuaternion,
                new OrientationFunction<Double, Quaternion, Quaternion>() {
                    @Override
                    public Quaternion apply(Double time, Quaternion lambda) throws SizeException, MultiplySideException {
                        return lambda
                                .multiplyWithQuaternion(omegaOptimalQuaternion, "right")
                                .multiplyWithScalar(0.5);
                    }
                }, step).get("quaternion"));

        Quaternion newPsiQuaternion = new Quaternion((Quaternion) getNextInRungeKutta(time, psiQuaternion,
                new OrientationFunction<Double, Quaternion, Quaternion>() {
                    @Override
                    public Quaternion apply(Double time, Quaternion psi) throws SizeException, MultiplySideException {
                        return psi
                                .multiplyWithQuaternion(omegaOptimalQuaternion, "right")
                                .multiplyWithScalar(0.5);
                    }
                }, step).get("quaternion"));

        double newTime = time + step;

        result.put("time", newTime);
        result.put("lambda", newLambdaQuaternion);
        result.put("psi", newPsiQuaternion);
        result.put("omega", new Quaternion(getOmegaOptimal(newLambdaQuaternion, newPsiQuaternion, alpha)));

        return result;
    }

    public static Quaternion getOmegaOptimal(Quaternion lambdaQuaternion, Quaternion psiQuaternion, Double[] alpha) throws IndexException {
        double psi0 = psiQuaternion.get(0);
        double psi1 = psiQuaternion.get(1);
        double psi2 = psiQuaternion.get(2);
        double psi3 = psiQuaternion.get(3);
        double lambda0 = lambdaQuaternion.get(0);
        double lambda1 = lambdaQuaternion.get(1);
        double lambda2 = lambdaQuaternion.get(2);
        double lambda3 = lambdaQuaternion.get(3);

        double p1 = (-psi0 * lambda1 + psi1 * lambda0 + psi2 * lambda3 - psi3 * lambda2) / (4 * alpha[0]);
        double p2 = (-psi0 * lambda2 - psi1 * lambda3 + psi2 * lambda0 + psi3 * lambda1) / (4 * alpha[1]);
        double p3 = (-psi0 * lambda3 + psi1 * lambda2 - psi2 * lambda1 + psi3 * lambda0) / (4 * alpha[2]);

        return new Quaternion(0, new Vector(p1, p2, p3));
    }

}

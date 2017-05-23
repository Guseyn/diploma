package guseyn.com.methods;

import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;
import guseyn.com.exceptions.ZeroException;
import guseyn.com.interfaces.OrientationFunction;
import guseyn.com.libs.Quaternion;

import java.util.HashMap;

public class RungeKutta {

    protected double leftEdgeOfSegment;
    protected double rightEdgeOfSegment;
    protected double step;

    public RungeKutta() {}

    public RungeKutta(double leftEdgeOfSegment, double rightEdgeOfSegment, double step) {
        this.leftEdgeOfSegment = leftEdgeOfSegment;
        this.rightEdgeOfSegment = rightEdgeOfSegment;
        this.step = step;
    }

    public HashMap solve(Quaternion quaternion, OrientationFunction<Double, Quaternion, Quaternion> f)
            throws ZeroException, MultiplySideException, SizeException {

        if (step == 0) {
            throw new ZeroException("step is 0");
        }

        int quantityOfIntervals =
                (int) ((rightEdgeOfSegment - leftEdgeOfSegment) / step);

        HashMap<String, Quaternion[]> result = new HashMap<String, Quaternion[]>();
        double[] time = new double[quantityOfIntervals];
        Quaternion[] solution = new Quaternion[quantityOfIntervals];

        time[0] = leftEdgeOfSegment;
        solution[0] = quaternion;

        for (int i = 1; i < quantityOfIntervals; i++) {
            HashMap nextInRKMethod = getNextInRungeKutta(time[i - 1],
                    solution[i - 1], f, step);
            time[i] = (Double) nextInRKMethod.get("time");
            solution[i] = (Quaternion) nextInRKMethod.get("quaternion");
        }

        result.put("quaternion", solution);
        return result;

    }

    protected static HashMap<String, Object> getNextInRungeKutta(Double currentTime,
                                                                 Quaternion currentQuaternion,
                                                                 OrientationFunction<Double, Quaternion, Quaternion> f,
                                                                 double step)
            throws MultiplySideException, SizeException {
        final double HF = 0.5;
        final double ONE_SIXTH = 1.0 / 6;
        double halfOfStep = HF * step;

        HashMap<String, Object> result = new HashMap<String, Object>();

        Quaternion k1 = new Quaternion(f.apply(currentTime, currentQuaternion));
        Quaternion k2 = new Quaternion(f.apply(currentTime + halfOfStep, currentQuaternion
                .plus(k1.multiplyWithScalar(halfOfStep))));
        Quaternion k3 = new Quaternion(f.apply(currentTime + halfOfStep, currentQuaternion
                .plus(k2.multiplyWithScalar(halfOfStep))));
        Quaternion k4 = new Quaternion(f.apply(currentTime + step, currentQuaternion
                .plus(k3.multiplyWithScalar(step))));

        Quaternion delta = new Quaternion((k1
                .plus(k2.multiplyWithScalar(2))
                .plus(k3.multiplyWithScalar(2))
                .plus(k4)
        ).multiplyWithScalar(step * ONE_SIXTH));

        result.put("time", currentTime + step);
        result.put("quaternion", currentQuaternion.plus(delta));

        return result;

    }

}

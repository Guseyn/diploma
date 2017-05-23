package guseyn.com.methods;


import guseyn.com.exceptions.IndexException;
import guseyn.com.libs.Quaternion;

public class QualityFunctional {

    Quaternion[] values;
    double step;
    Double[] alpha;

    public QualityFunctional(Quaternion[] values, double step, Double[] alpha) {
        this.values = values;
        this.step = step;
        this.alpha = alpha;
    }

    public double get() throws IndexException {
        double result = f(0) + f(values.length - 1);
        for (int i = 0; i < values.length; i++) {
            if (i != values.length - 1) {
                if (i % 2 == 0) {
                    result += 2 * f(i);
                } else {
                    result += 4 * f(i);
                }
            }
        }
        return result * (step / 3.0);
    }

    private double f(int j) throws IndexException {
        return alpha[0] * Math.pow(values[j].get(1), 2)
                + alpha[1] * Math.pow(values[j].get(2), 2)
                + alpha[2] * Math.pow(values[j].get(3), 2);
    }

}

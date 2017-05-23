package guseyn.com.main;

import guseyn.com.exceptions.*;
import guseyn.com.interfaces.NonLinearFunction;
import guseyn.com.libs.Quaternion;
import guseyn.com.methods.Newton;
import guseyn.com.methods.QualityFunctional;
import guseyn.com.methods.RungeKuttaSpecific;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    final static String LAMBDA_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-lambda.r";
    final static String OMEGA_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-omega.r";
    final static String PSI_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-psi.r";
    final static String ANGELS_ALPHA_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-angels-alpha.r";
    final static String ANGELS_BETA_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-angels-beta.r";
    final static String ANGELS_GAMMA_PATH = "/home/guseyn/diploma/src/guseyn/com/output/plot2d-angels-gamma.r";

    protected static Quaternion lambda_t0;
    protected static Quaternion lambda_T;
    protected static double e;

    protected static Double leftEdgeOfSegment;
    protected static Double rightEdgeOfSegment;
    protected static Double step;
    protected static Double[] alpha;
    protected static Quaternion approximation;

    private static void graph(Quaternion[] solution, Quaternion[] omega, Quaternion[] psi) throws IndexException, IOException {
        GraphString.$$(solution, LAMBDA_PATH, step, true, 500, -1, 1,
                "text(95, 0, expression(lambda[0]));"
                        + "text(180, -0.70, expression(lambda[1]));"
                        + "text(25, 0.75, expression(lambda[3]));"
                        + "text(75, -0.55, expression(lambda[4]))");
        GraphString.$$(omega, OMEGA_PATH, step, false, 500, -0.02, 0.02,
                "text(10, 0.01, expression(omega[1]));"
                        + "text(10, 0.0, expression(omega[2]));"
                        + "text(10, -0.012, expression(omega[3]))");
        GraphString.$$(psi, PSI_PATH, step, true, 500, -180000, 180000,
                "text(95, 0, expression(psi[0]));"
                        + "text(75, 111000, expression(psi[3]));"
                        + "text(75, -115000, expression(psi[2]));"
                        + "text(27, 0, expression(psi[1]))");
        double[] alpha = new double[solution.length];
        double[] beta = new double[solution.length];
        double[] gamma = new double[solution.length];
        double[] x = new double[solution.length];
        for (int i = 0; i < solution.length; i++) {
            Double[] angels = Quaternion.getEulerAngels(solution[i]);
            alpha[i] = angels[0];
            beta[i] = angels[1];
            gamma[i] = angels[2];
            x[i] = i * step;
        }
        GraphString.$(x, alpha, "t", "alpha", "t", "α", 200, true, ANGELS_ALPHA_PATH, false);
        GraphString.$(x, beta, "t", "beta", "t", "β", 200, true, ANGELS_BETA_PATH, false);
        GraphString.$(x, gamma, "t", "gamma", "t", "γ", 200, true, ANGELS_GAMMA_PATH, true);
    }

    public static void solve() throws MultiplySideException, ZeroException, IndexException, SizeException, NotResolvableNewtonMethodException, IOException {

        final RungeKuttaSpecific rungeKuttaSpecific = new RungeKuttaSpecific(leftEdgeOfSegment,
                rightEdgeOfSegment, step, lambda_t0, alpha);

        NonLinearFunction<Quaternion, Quaternion[]> RK = new NonLinearFunction<Quaternion, Quaternion[]>() {
            @Override
            public Quaternion[] apply(Quaternion psi) throws ZeroException,
                    MultiplySideException,
                    SizeException, IndexException {
                return (Quaternion[]) rungeKuttaSpecific.solve(psi).get("lambda");
            }
        };

        HashMap result = new Newton(approximation, lambda_T, RK, e).solve();
        Quaternion[] solution = (Quaternion[]) result.get("solution");
        Quaternion approximation = (Quaternion) result.get("approximation");
        Quaternion[] omega = (Quaternion[]) rungeKuttaSpecific.solve(approximation).get("omega");
        Quaternion[] psi = (Quaternion[]) rungeKuttaSpecific.solve(approximation).get("psi");
        double quality = new QualityFunctional(omega, step, alpha).get();
        System.out.println("omega0:\n" + omega[0]);
        System.out.println("psi0:\n" + psi[0]);
        System.out.println("quality: \n" + quality);

        graph(solution, omega, psi);
    }

    public static void main(String[] args) throws Exception {
        BA.t300();
    }

}

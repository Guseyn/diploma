package guseyn.com.methods;

import guseyn.com.exceptions.*;
import guseyn.com.interfaces.NonLinearFunction;
import guseyn.com.libs.QMatrix;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.util.Arrays;
import java.util.HashMap;

public class Newton {

    private Quaternion approximation;
    private Quaternion exactValue;
    private NonLinearFunction<Quaternion, Quaternion[]> f;
    private double e;

    private Quaternion[] solution;
    private Quaternion mainDiscrepancy;
    private double[] xi = new double[] {1, 0.5, 0.25,  0.125, 0.0625,
            0.03125, 0.015625, 0.0078125, 0.00390625, 0.001953125,
            0.000976563, 0.000488281, 0.000244141, 0.00012207,
            0.000061035, 0.000030518, 0.000015259, 0.000007629,
            0.000003815, 0.000001907, 0.000000954, 0.000000477,
            0.000000238, 0.000000119, 0.00000006, 0.00000003,
            0.000000015, 0.0000000075, 0.00000000375, 0.000000001875,
            0.0000000009375};
    private boolean isNextInvoked = false;

    public Newton(Quaternion approximation, Quaternion exactValue,
                  NonLinearFunction<Quaternion, Quaternion[]> f, double e) {
        this.approximation = approximation;
        this.exactValue = exactValue;
        this.f = f;
        this.e = e;
    }

    public HashMap<String, Object> solve() throws ZeroException, MultiplySideException,
            SizeException, IndexException, NotResolvableNewtonMethodException {
        HashMap<String, Object> result = new HashMap<String, Object>();
        int count = 1;
        while (!isExitCondition()) {
            getNextApproximation(count);
            count++;
        }
        result.put("solution", solution);
        result.put("approximation", approximation);
        return result;
    }

    private void getNextApproximation(int count) throws SizeException,
            MultiplySideException, ZeroException, NotResolvableNewtonMethodException, IndexException {

        System.out.println();
        System.out.println("#######################################################");
        System.out.println(count);
        Quaternion[] diffs = getDiscrepancyDiffs();
        System.out.println("diffs: \n" + Arrays.toString(diffs) + "\n");
        System.out.println("determinant: \n" + QMatrix.getDeterminant(diffs) + "\n");
        Quaternion rightSideOfSLE = mainDiscrepancy.multiplyWithScalar(-1.0);
        this.isNextInvoked = true;

        double mainDiscrepancyValue = getDiscrepancyValue(mainDiscrepancy);
        boolean status = false;

        Quaternion delta = new Gauss(diffs, rightSideOfSLE).solve();
        System.out.println("real b: \n" + rightSideOfSLE + "\n");
        System.out.println("Gauss b: \n" + Gauss.checkB(diffs, delta) + "\n");

        for (double x: xi) {
            System.out.println("===================================================");
            System.out.println("xi: " + x);
            Quaternion newApproximation = new Quaternion(approximation.plus(delta.multiplyWithScalar(x)));
            System.out.println("new approximation: " + newApproximation);
            Quaternion[] newSolution = f.apply(newApproximation);
            Quaternion newDiscrepancy = new Quaternion(getDiscrepancy(newSolution));
            double newDiscrepancyValue = getDiscrepancyValue(newDiscrepancy);
            System.out.println("new discrepancyValue: " + newDiscrepancyValue + "\n");
            if (newDiscrepancyValue < mainDiscrepancyValue) {
                this.approximation = new Quaternion(newApproximation);
                this.solution = newSolution;
                this.mainDiscrepancy = new Quaternion(newDiscrepancy);
                status = true;
                break;
            }
        }

        System.out.println("approximation: \n" + approximation);
        System.out.println("discrepancy: \n" + mainDiscrepancy);
        System.out.println("discrepancyValue: \n" + getDiscrepancyValue(mainDiscrepancy) + "\n");

        if(!status) {
            throw new NotResolvableNewtonMethodException("not resolvable");
        }
    }

    private Quaternion[] getDiscrepancyDiffs() throws ZeroException, MultiplySideException, SizeException, IndexException {
        double delta = 0.00000001;
        double reverseDelta = 1.0 / delta;

        Quaternion[] f1 = f.apply(new Quaternion(approximation.getScalar() + delta,
                approximation.getVector()));
        Quaternion[] f2 = f.apply(new Quaternion(approximation.getScalar(),
                new Vector(approximation.getICoefficient() + delta,
                        approximation.getJCoefficient(),
                        approximation.getKCoefficient())));
        Quaternion[] f3 = f.apply(new Quaternion(approximation.getScalar(),
                new Vector(approximation.getICoefficient(),
                        approximation.getJCoefficient() + delta,
                        approximation.getKCoefficient())));
        Quaternion[] f4 = f.apply(new Quaternion(approximation.getScalar(),
                new Vector(approximation.getICoefficient(),
                        approximation.getJCoefficient(),
                        approximation.getKCoefficient() + delta)));

        return new Quaternion[] {
                getDiscrepancy(f1).minus(mainDiscrepancy).multiplyWithScalar(reverseDelta),
                getDiscrepancy(f2).minus(mainDiscrepancy).multiplyWithScalar(reverseDelta),
                getDiscrepancy(f3).minus(mainDiscrepancy).multiplyWithScalar(reverseDelta),
                getDiscrepancy(f4).minus(mainDiscrepancy).multiplyWithScalar(reverseDelta)
        };

    }

    private Quaternion getDiscrepancy(Quaternion[] solution) throws ZeroException, MultiplySideException, SizeException {
        return solution[solution.length - 1].minus(exactValue);
    }

    private double getDiscrepancyValue(Quaternion discrepancy) {
        return Math.abs(discrepancy.getScalar())
                + Math.abs(discrepancy.getICoefficient())
                + Math.abs(discrepancy.getJCoefficient())
                + Math.abs(discrepancy.getKCoefficient());
    }

    private boolean isExitCondition() throws ZeroException, MultiplySideException, SizeException, IndexException {
        if (!isNextInvoked) {
            this.solution = f.apply(approximation);
            this.mainDiscrepancy = getDiscrepancy(solution);
        }
        return getDiscrepancyValue(mainDiscrepancy) < e;
    }


}

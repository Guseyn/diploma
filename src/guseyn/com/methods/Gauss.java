package guseyn.com.methods;

import guseyn.com.exceptions.IndexException;
import guseyn.com.exceptions.SizeException;
import guseyn.com.exceptions.ZeroException;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.util.Arrays;
import java.util.HashMap;

public class Gauss {

    private Quaternion[] a;
    private Quaternion b;
    int[] jmaxes = new int[Quaternion.SIZE];

    public Gauss(Quaternion[] a, Quaternion b) {
        this.a = Quaternion.cloneArray(a);
        this.b = Quaternion.clone(b);
    }

    public Quaternion solve() throws SizeException, IndexException, ZeroException {
        if (a.length == Quaternion.SIZE) {

            Quaternion.transpose(a);
            Quaternion solution = new Quaternion(0, new Vector(0, 0, 0));

            for (int i = 0; i < Quaternion.SIZE; i++) {
                HashMap<String, Integer> maxIndexes = findMaxElement(i);
                int imax = maxIndexes.get("i");
                int jmax = maxIndexes.get("j");
                swapTwoEquations(imax, i);
                for (int j = i + 1; j < Quaternion.SIZE; j++) {
                    double c = -1.0 * a[j].get(jmax) / a[i].get(jmax);
                    for (int k = 0; k < Quaternion.SIZE; k++) {
                        if (!Arrays.asList(jmaxes).contains(k)) {
                            a[j].set(k, a[j].get(k) + a[i].get(k) * c);
                            if (k == jmax) {
                                a[j].set(k, 0);
                            }
                        }
                    }
                    b.set(j, b.get(j) + b.get(i) * c);
                }
                jmaxes[i] = jmax;
            }

            Integer[] indexes = new Integer[Quaternion.SIZE];

            for (int n = Quaternion.SIZE - 1; n >= 0; n--) {
                double s = 0;
                double p = 0;
                int solutionIndex = 0;
                for (int m = 0; m < Quaternion.SIZE; m++) {
                    if (indexes[m] == null && a[n].get(m) != 0.0) {
                        indexes[m] = 1;
                        p = a[n].get(m);
                        solutionIndex = m;
                    } else if (indexes[m] != null && a[n].get(m) != 0) {
                        s += a[n].get(m) * solution.get(m);
                    }
                }
                solution.set(solutionIndex, (b.get(n) - s) / p);

            }

            return solution;

        } else {
            throw new SizeException("size of a is not 4");
        }
    }

    public static Quaternion checkB(Quaternion[] a, Quaternion solution) throws IndexException {
        Quaternion b = new Quaternion(0, new Vector(0, 0, 0));
        for (int i = 0; i < Quaternion.SIZE; i++) {
            double s = 0;
            for (int j = 0; j < Quaternion.SIZE; j++) {
                s += a[j].get(i) * solution.get(j);
            }
            b.set(i, s);
        }
        return b;
    }

    public HashMap<String, Integer> findMaxElement(int step) throws IndexException {
        int imax = step;
        int jmax = step;
        for (int i = step; i < Quaternion.SIZE; i++) {
            for (int j = 0; j < Quaternion.SIZE; j++) {
                if (!Arrays.asList(jmaxes).contains(j)) {
                    if (Math.abs(a[i].get(j)) > Math.abs(a[imax].get(jmax))) {
                        imax = i; jmax = j;
                    }
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("i", imax);
        result.put("j", jmax);
        return result;
    }

    public void swapTwoEquations(int i, int step) throws IndexException {
        Quaternion ai = a[i];
        a[i] = a[step];
        a[step] = ai;
        double bi = b.get(i);
        b.set(i, b.get(step));
        b.set(step, bi);
    }


}
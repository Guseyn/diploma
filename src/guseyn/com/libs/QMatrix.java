package guseyn.com.libs;

import guseyn.com.exceptions.IndexException;
import guseyn.com.exceptions.SizeException;

public class QMatrix {

    private static final int SIZE3 = 3;
    private static final int SIZE4 = 4;

    public static double getDeterminant(Quaternion[] q) throws IndexException, SizeException {
        double[][] a = new double[SIZE4][SIZE4];
        for (int i = 0; i < Quaternion.SIZE; i++) {
            for (int j = 0; j < Quaternion.SIZE; j++) {
                a[i][j] = q[i].get(j);
            }
        }

        double result = 0;
        for (int i = 0; i < SIZE4; i++) {
            double[][] M = getM(a, SIZE4, i);
            double d = get3Determinant(M);
            double r = a[0][i] * d;
            result += (i % 2 == 0) ? r : -r;
        }
        return result;
    }

    private static double get3Determinant(double a[][]) {
        double result = 0;
        for (int i = 0; i < SIZE3; i++) {
            double[][] M = getM(a, SIZE3, i);
            double d = get2Determinant(M);
            double r = a[0][i] * d;
            result += (i % 2 == 0) ? r : -r;
        }

        return result;
    }

    private static double get2Determinant(double[][] a) {
        return a[0][0] * a[1][1] - a[1][0] * a[0][1];
    }

    private static double[][] getM(double[][] a, int size, int index) {
        double[][] d = new double[size - 1][size - 1];
        for (int j = 1, n = 0; j < size; j++, n++) {
            int m = 0;
            for (int k = 0; k < size; k++) {
                if (k != index) {
                    d[n][m] = a[j][k];
                    m++;
                }
            }
        }
        return d;
    }

}

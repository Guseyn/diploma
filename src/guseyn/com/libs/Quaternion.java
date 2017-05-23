package guseyn.com.libs;

import guseyn.com.exceptions.IndexException;
import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;

/*Класс - кватернион*/

public class Quaternion {

    private double scalar;
    private Vector vector;
    public final static int SIZE = 4;
    public final static int VECTOR_SIZE = 3;

    public Quaternion(Quaternion quaternion) {
        this.scalar = quaternion.getScalar();
        this.vector = new Vector(quaternion.getVector());
    }

    public Quaternion(double scalar, Vector vector) {
        this.scalar = scalar;
        this.vector = new Vector(vector);
    }

    public Quaternion getPairingQuaternion() {
        return new Quaternion(scalar, vector.multiplyWithScalar(-1));
    }

    public double getNorm() {
        return Math.sqrt(Math.pow(scalar, 2) +
                Math.pow(getICoefficient(), 2) +
                Math.pow(getJCoefficient(), 2) +
                Math.pow(getKCoefficient(), 2));
    }

    public Quaternion plus(Quaternion quaternion) throws SizeException {
        return new Quaternion(scalar + quaternion.scalar,
                vector.plus(quaternion.vector)
        );
    }

    public Quaternion minus(Quaternion quaternion) throws SizeException {
        return this.plus(quaternion.multiplyWithScalar(-1));
    }

    public Quaternion multiplyWithScalar(double s) {
        return new Quaternion(scalar * s, vector.multiplyWithScalar(s));
    }

    public Quaternion multiplyWithQuaternion(Quaternion quaternion, String side) throws SizeException,
            MultiplySideException {
        if (quaternion.getVector().getSize() == VECTOR_SIZE) {
            double s = scalar * quaternion.scalar -
                    vector.scalarMultiplyWithVector(quaternion.vector);
            Vector v = quaternion.getVector().
                    multiplyWithScalar(scalar).
                    plus(vector.multiplyWithScalar(quaternion.scalar)).
                    plus(vector.vectorMultiplyWith3DVector(quaternion.vector, side));
            return new Quaternion(s, v);
        } else {
            throw new SizeException("quaternionMultiplication size e");
        }
    }

    public Quaternion normalize() {
        return this.multiplyWithScalar(1.0 / getNorm());
    }

    public Quaternion getReverseQuaternion() {
        double s = 1.0 / Math.pow(getNorm(), 2);
        return getPairingQuaternion().multiplyWithScalar(s);
    }

    public static void transpose(Quaternion[] quaternions) throws IndexException {
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                double tmp = quaternions[i].get(j);
                quaternions[i].set(j, quaternions[j].get(i));
                quaternions[j].set(i, tmp);
            }
        }
    }

    public static Quaternion getFromEulerAngles(double phi, double teta, double psi) {
        phi = Math.toRadians(phi) / 2;
        teta = Math.toRadians(teta) / 2;
        psi = Math.toRadians(psi) / 2;
        return new Quaternion(Math.cos(phi) * Math.cos(teta) * Math.cos(psi)
                + Math.sin(phi) * Math.sin(teta) * Math.sin(psi),
                new Vector(Math.sin(phi) * Math.cos(teta) * Math.cos(psi) -
                        Math.cos(phi) * Math.sin(teta) * Math.sin(psi),
                        Math.cos(phi) * Math.sin(teta) * Math.cos(psi) +
                                Math.sin(phi) * Math.cos(teta) * Math.sin(psi),
                        Math.cos(phi) * Math.cos(teta) * Math.sin(psi) -
                                Math.sin(phi) * Math.sin(teta) * Math.cos(psi)));
    }

    public static Double[] getEulerAngels(Quaternion q) throws IndexException {
        double phi = Math.toDegrees(Math.atan2(2 * (q.get(0) * q.get(1) + q.get(2) * q.get(3)),
                (1 - 2 * (Math.pow(q.get(1), 2) + Math.pow(q.get(2), 2)))));
        double teta = Math.toDegrees(Math.asin(2 * (q.get(0) * q.get(2) - q.get(3) * q.get(1))));
        double psi = Math.toDegrees(Math.atan2(2 * (q.get(0) * q.get(3) + q.get(1) * q.get(2)),
                (1 - 2 * (Math.pow(q.get(2), 2) + Math.pow(q.get(3), 2)))));
        return new Double[]{phi, teta, psi};
    }

    public static Quaternion clone(Quaternion q) {
        return new Quaternion(q.scalar,
                new Vector(q.getICoefficient(), q.getJCoefficient(), q.getKCoefficient()));
    }

    public static Quaternion[] cloneArray(Quaternion[] q) {
        Quaternion[] q2 = new Quaternion[q.length];
        for (int i = 0; i < q.length; i++) {
            q2[i] = Quaternion.clone(q[i]);
        }
        return q2;
    }

    public double get(int index) throws IndexException {
        if (index == 0) {
            return getScalar();
        } else if (index > 0 && index < SIZE) {
            return vector.getCoordinate(index - 1);
        } else {
            throw new IndexException("Quaternion index is over than 3");
        }
    }

    public void set(int index, double value) throws IndexException {
        if (index == 0) {
            scalar = value;
        } else if (index > 0 && index < SIZE) {
            vector.setCoordinate(index - 1, value);
        } else {
            throw new IndexException("Quaternion index is over than 3");
        }
    }

    public double getICoefficient() {
        return vector.getCoordinate(0);
    }

    public double getJCoefficient() {
        return vector.getCoordinate(1);
    }

    public double getKCoefficient() {
        return vector.getCoordinate(2);
    }

    public double getScalar() {
        return scalar;
    }

    public Vector getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return "Quaternion{" +
                "scalar=" + scalar +
                ", vector=" + vector +
                "} \n";
    }
}

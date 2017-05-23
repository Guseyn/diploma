package guseyn.com.libs;

import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;

import java.util.Arrays;

public class Vector {

    private int size;
    private double[] coordinates;

    public Vector(double... values) {
        this.size = values.length;
        this.coordinates = values;
    }

    public Vector(Vector vector) {
        this.size = vector.size;
        this.coordinates = vector.coordinates;
    }

    public Vector plus(Vector vector) throws SizeException {
        double[] values = new double[size];
        if (size == vector.size) {
            for (int i = 0; i < size; i++) {
                values[i] = coordinates[i] + vector.getCoordinate(i);
            }
        } else {
            throw new SizeException("plus size e");
        }
        return new Vector(values);
    }

    public Vector minus(Vector vector) throws SizeException {
        return this.plus(vector.multiplyWithScalar(-1));
    }

    public Vector multiplyWithScalar(double scalar) {
        double[] values = new double[size];
        for (int i = 0; i < size; i++) {
            values[i] = coordinates[i] * scalar;
        }
        return new Vector(values);
    }

    public double scalarMultiplyWithVector(Vector vector) throws SizeException {
        double res = 0;
        if (size == vector.size) {
            for (int i = 0; i < size; i++) {
                res += coordinates[i] * vector.getCoordinate(i);
            }
        } else {
            throw new SizeException("scalarMultiplyWithVector size e");
        }
        return res;
    }

    public Vector vectorMultiplyWith3DVector(Vector vector, String side) throws SizeException,
                                                                                MultiplySideException {
        if (size == 3) {
            double c0 = vector.getCoordinate(0);
            double c1 = vector.getCoordinate(1);
            double c2 = vector.getCoordinate(2);
            boolean isLeft = side.equals("left");
            boolean isRight = side.equals("right");
            Vector result = new Vector(
                    coordinates[1] * c2 - coordinates[2] * c1,
                    coordinates[2] * c0 - coordinates[0] * c2,
                    coordinates[0] * c1 - coordinates[1] * c0
            );
            if (isLeft) {
                return result.multiplyWithScalar(-1);
            } else if (isRight) {
                return result;
            } else {
                throw new MultiplySideException("vectorMultiplyWith3DVector multiply side e");
            }
        } else {
            throw new SizeException("vectorMultiplyWith3DVector size e");
        }
    }

    public double getDescartesLength() {
        double length = 0;
        for (int i = 0; i < size; i++) {
            length += Math.pow(getCoordinate(i), 2);
        }
        return Math.sqrt(length);
    }

    public Vector normalize() {
        return this.multiplyWithScalar(1.0 / getDescartesLength());
    }

    public Quaternion getRotationQuaternion(double angle) throws SizeException {
        double radian = Math.PI / 180;
        angle *= radian;
        if (size == 3) {
            double halfAngleSin = Math.sin(angle / 2);
            double halfAngleCos = Math.cos(angle / 2);
            return new Quaternion(halfAngleCos,
                    this.normalize().multiplyWithScalar(halfAngleSin));
        } else {
            throw new SizeException("getRotationQuaternion size e");
        }
    }

    public int getSize() {
        return size;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public double getCoordinate(int position) {
        return coordinates[position];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCoordinates(double... coordinates) {
        this.coordinates = coordinates;
        this.size = coordinates.length;
    }

    public void setCoordinate(int index, double value) {
        this.coordinates[index] = value;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "size=" + size +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}

package guseyn.com.examples;

import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

public class QuaternionAlgebraExample {

    public static void main(String[] args) throws Exception {
        final Quaternion quaternion = new Quaternion(2, new Vector(3, 5, 7));
        Quaternion quaternion1 = new Quaternion(2, new Vector(5, 7, 9));
        Quaternion res = quaternion
                .minus(quaternion)
                .plus(quaternion)
                .getPairingQuaternion()
                .getPairingQuaternion()
                .getReverseQuaternion()
                .getReverseQuaternion()
                .multiplyWithScalar(4)
                .multiplyWithScalar(0.25)
                .multiplyWithQuaternion(quaternion1, "right")
                .multiplyWithQuaternion(quaternion1.getReverseQuaternion(), "right");
        System.out.println(res.toString());
        System.out.println("##############################");
        Vector vector = new Vector(1, 2, 3);
        Quaternion rotationQuaternion = vector.getRotationQuaternion(15);
        System.out.println(rotationQuaternion);
        System.out.println("##############################");
    }

}

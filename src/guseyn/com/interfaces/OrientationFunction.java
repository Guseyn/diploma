package guseyn.com.interfaces;

import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;

@FunctionalInterface
public interface OrientationFunction< InputTime, InputQuaternion, OutputQuaternion> {
    public OutputQuaternion apply(InputTime inputTime, InputQuaternion inputQuaternion) throws SizeException, MultiplySideException;
}

package guseyn.com.interfaces;

import guseyn.com.exceptions.IndexException;
import guseyn.com.exceptions.MultiplySideException;
import guseyn.com.exceptions.SizeException;
import guseyn.com.exceptions.ZeroException;
import guseyn.com.libs.Quaternion;

@FunctionalInterface
public interface NonLinearFunction<Approximation, Solution> {

    public Solution apply(Approximation approximation) throws ZeroException, MultiplySideException, SizeException, IndexException;
}

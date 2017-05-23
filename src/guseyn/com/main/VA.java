package guseyn.com.main;

import guseyn.com.exceptions.*;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.io.IOException;

public class VA extends Main {


    private static void va(Double[] angels, Quaternion appr) throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        lambda_t0 = Quaternion.getFromEulerAngles(angels[0], angels[1], angels[2]).normalize();
        System.out.println(Main.lambda_t0);
        lambda_T = new Quaternion(1, new Vector(0, 0, 0));
        leftEdgeOfSegment = 0.0;
        rightEdgeOfSegment = 300.0;
        step = 0.001;
        alpha = new Double[]{1000.0, 2000.0, 3000.0};
        approximation = appr;
        e = Math.pow(10, -9);
        solve();
    }

    public static void a_0_0_0() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{0.0, 0.0, 0.0}, new Quaternion(0, new Vector(0, 0, 0)));
        /*0.0*/
    }

    public static void a_1_1_1() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{1.0, 1.0, 1.0}, new Quaternion(-75729.33380462334, new Vector(-655.3427361351245, -667.1163582269645, -655.8040871052124)));
        /*0.006056692698154153*/
    }

    public static void a_2_2_2() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{2.0, 2.0, 2.0}, new Quaternion(-5443.153033484646, new Vector(-93.80912077901316, -97.61575664501297, -94.72363642274485)));
        /*0.02408215835432236*/
    }

    public static void a_3_3_3() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{3.0, 3.0, 3.0}, new Quaternion(9805.360233463527, new Vector(249.35401052077052, 262.04781508500344, 247.99458595045195)));
        /*0.05385534350818591*/
    }

    public static void a_4_4_4() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{4.0, 4.0, 4.0}, new Quaternion(1, new Vector(0, 0, 0)));
        /*0.09514985533820493*/
    }

    public static void a_5_5_5() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{5.0, 5.0, 5.0}, new Quaternion(1, new Vector(0, 0, 0)));
        /*0.1477341814913685*/
    }

    public static void a_6_6_6() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{6.0, 6.0, 6.0}, new Quaternion(1, new Vector(0, 0, 0)));
        /*0.21137190897814612*/
    }

    public static void a_7_7_7() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{7.0, 7.0, 7.0}, new Quaternion(1, new Vector(0, 0, 0)));
        /*0.28582194497504043*/
    }

    public static void a_8_8_8() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{8.0, 8.0, 8.0}, new Quaternion(261.603019760134, new Vector(15.268156363226858, 15.571142832654283, 11.81091605516897)));
        /*0.3708387365805886*/
    }

    public static void a_9_9_9() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{9.0, 9.0, 9.0}, new Quaternion(0, new Vector(0, 0, 0)));
        /*0.46617248981673004*/
    }

    public static void a_10_10_10() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{10.0, 10.0, 10.0}, new Quaternion(-108.91482610027819, new Vector(-10.828730089069975, -15.437524252648867, -15.064155582274143)));
        /*0.5715693910515096*/
    }

    public static void a_11_11_11() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{11.0, 11.0, 11.0}, new Quaternion(-2.187114325473687, new Vector(-2.524271906598756, -5.870468396285327, -7.135295074348243)));
        /*0.6867718203349862*/
    }

    public static void a_12_12_12() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{12.0, 12.0, 12.0}, new Quaternion(-215.2490288647313, new Vector(-22.74782148519381, -31.179552994191802, -27.725285662043404)));
        /*0.8115185700197344*/
    }

    public static void a_13_13_13() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{13.0, 13.0, 13.0}, new Quaternion(844.9644983379583, new Vector(82.46310353747427, 100.29784447608482, 77.12848019903025)));
        /*0.9455450560043213*/
    }

    public static void a_14_14_14() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{14.0, 14.0, 14.0}, new Quaternion(402.7317379567533, new Vector(40.39888676608347, 48.047498544903625, 34.71651486360227)));
        /*1.0885835236291768*/
    }

    public static void a_15_15_15() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{15.0, 15.0, 15.0}, new Quaternion(-2302.873157203677, new Vector(-265.745619740652, -350.2794438164233, -271.76619768799594)));
        /*1.2403632727704637*/
    }

    public static void a_16_16_16() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{16.0, 16.0, 16.0}, new Quaternion(8477.969464647038, new Vector(1017.9529055720016, 1346.6198031688073, 1011.6037985878293)));
        /*1.4006108189429844*/
    }

    public static void a_17_17_17() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{17.0, 17.0, 17.0}, new Quaternion(-2.187114325473687, new Vector(-2.524271906598756, -5.870468396285327, -7.135295074348243)));
        /*1.5690501304510134*/
    }

    public static void a_18_18_18() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{18.0, 18.0, 18.0}, new Quaternion(-2.187114325473687, new Vector(-2.524271906598756, -5.870468396285327, -7.135295074348243)));
        /*1.7454027952571545*/
    }

    public static void a_19_19_19() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{19.0, 19.0, 19.0}, new Quaternion(-2.187114325473687, new Vector(-2.524271906598756, -5.870468396285327, -7.135295074348243)));
        /*1.929388211767391*/
    }

    public static void a_20_20_20() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{20.0, 20.0, 20.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*2.1207237623553117*/
    }

    public static void a_21_21_21() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{21.0, 21.0, 21.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*2.319124980674097*/
    }

    public static void a_22_22_22() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{22.0, 22.0, 22.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*2.5243057234840194*/
    }

    public static void a_23_23_23() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{23.0, 23.0, 23.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*2.735978298083406*/
    }

    public static void a_24_24_24() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{24.0, 24.0, 24.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*2.9538536340429173*/
    }

    public static void a_25_25_25() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{25.0, 25.0, 25.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*3.1776413757372017*/
    }

    public static void a_26_26_26() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{26.0, 26.0, 26.0}, new Quaternion(0, new Vector(-0, -0, -0)));
        /*3.4070500639069183*/
    }

    public static void a_27_27_27() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{27.0, 27.0, 27.0}, new Quaternion(0, new Vector(0, 0, 1)));
        /*3.641787193331258*/
    }

    public static void a_28_28_28() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{28.0, 28.0, 28.0}, new Quaternion(10078.22224723853, new Vector(1852.3491563492437, 3074.72579137274, 1842.862829650452)));
        /*3.8815593424146697*/
    }

    public static void a_29_29_29() throws ZeroException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, SizeException {
        va(new Double[]{29.0, 29.0, 29.0}, new Quaternion(0, new Vector(1, 0, 1)));
        /*3.8815593424146697*/
    }

}

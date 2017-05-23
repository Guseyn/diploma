package guseyn.com.main;

import guseyn.com.exceptions.*;
import guseyn.com.libs.Quaternion;
import guseyn.com.libs.Vector;

import java.io.IOException;

public class LA extends Main {


    private static void la(double time, Double[] a, Quaternion appr) throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        lambda_t0 = Quaternion.getFromEulerAngles(5, 8, 10).normalize();
        System.out.println(Main.lambda_t0);
        lambda_T = new Quaternion(1, new Vector(0, 0, 0));
        leftEdgeOfSegment = 0.0;
        rightEdgeOfSegment = time;
        step = 0.001;
        alpha = a;
        approximation = appr;
        e = Math.pow(10, -9);
        solve();
    }

    public static void t200() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(200.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(555.0056807102058,
                new Vector(19.324470867280926, 35.008893484072814, 36.71519525806053)));
        /*0.6665346560157165*/
    }

    public static void t210() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(210.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(178.4476738053089,
                new Vector(5.26282044895343, 7.52784693998469, 5.411385817608004)));
        /*0.6347947090668907*/
    }

    public static void t220() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(220.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(871.5467669138119,
                new Vector(31.342209833476186, 58.8837781312651, 64.35671701191472)));
        /*0.6059402291411088*/
    }

    public static void t230() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(230.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(793.7963502564326,
                new Vector(28.483545064130965, 53.38507371580096, 58.194143216600324)));
        /*0.5795948495036541*/
    }

    public static void t240() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(240.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3142.3293357944954,
                new Vector(116.68588963575621, 226.74939326716526, 256.8081591889976)));
        /*0.5554449303187555*/
    }

    public static void t250() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(250.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3416.696976007324,
                new Vector(127.03398246656617, 247.17468444352835, 280.30618585245367)));
        /*0.5332270138435539*/
    }

    public static void t260() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(260.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3098.660622202883,
                new Vector(115.14344540855724, 223.90867829125727, 253.7716010710758)));
        /*0.512718177373356*/
    }

    public static void t270() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(270.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3006.118983599852,
                new Vector(111.71299331724653, 217.2542410254078, 246.24861315904724)));
        /*0.4937285213805331*/
    }

    public static void t280() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(280.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2987.5183742192557,
                new Vector(111.05471231840951, 216.039223888855, 244.94658880301503)));
        /*0.47609527601585777*/
    }

    public static void t290() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(290.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2995.799535316775,
                new Vector(111.40263904867169, 216.7953351352821, 245.89524618416098)));
        /*0.45967812105185146*/
    }

    public static void t300() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2756.976547932786,
                new Vector(102.4735036378071, 199.32350514907586, 225.96844846753726)));
        /*0.44435544985946895*/
    }

    public static void t310() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(310.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3129.931249260763,
                new Vector(116.50405551798323, 226.9474167958926, 257.6686377419513)));
        /*0.4300213419788282*/
    }

    public static void t320() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(320.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(3137.3639127224137,
                new Vector(116.81340199467581, 227.61455756020553, 258.5003768583104)));
        /*0.4165831192013803*/
    }

    public static void t330() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(330.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2824.4614071571677,
                new Vector(105.09773105320718, 204.6571398629003, 232.27926541307656)));
        /*0.4039593366750249*/
    }

    public static void t340() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(340.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2501.6476765537445,
                new Vector(93.00838246630697, 180.9624134814448, 205.21022652380987)));
        /*0.39207813322040375*/
    }

    public static void t350() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(350.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2321.5571837252032,
                new Vector(86.27434682190311, 167.78421715180454, 190.17856784092882)));
        /*0.3808758580825576*/
    }

    public static void t360() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(360.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2343.650388930169,
                new Vector(87.12748824710992, 169.50689128808966, 192.20438814885784)));
        /*0.3702959339180532*/
    }

    public static void t370() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(370.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2196.644278173746,
                new Vector(81.6325130559088, 158.7573167481985, 179.9473247455873)));
        /*0.3602878996580692*/
    }

    public static void t380() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(380.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2343.650388930169,
                new Vector(87.12748824710992, 169.50689128808966, 192.20438814885784)));
        /*0.35080660573398065*/
    }

    public static void t390() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(390.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2429.6320935646786,
                new Vector(90.41903490779997, 176.09862426442282, 199.89546518155188)));
        /*0.34181153391470087*/
    }

    public static void t400() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(400.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2506.162543284163,
                new Vector(93.31077666449899, 181.81675044712046, 206.4855633250728)));
        /*0.3332662171330903*/
    }

    public static void alpha121() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 1000.0}, new Quaternion(3888.1823539569405,
                new Vector(144.9323895835414, 282.7337668595258, 325.95708126651743)));
        /*0.2561562129231243*/
    }

    public static void alpha122() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 2000.0}, new Quaternion(3142.0094824018233,
                new Vector(116.92411488904986, 227.710973649992, 260.71572309653664)));
        /*0.3504523223918996*/
    }

    public static void alpha123() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 3000.0}, new Quaternion(2756.976547932786,
                new Vector(102.4735036378071, 199.32350514907586, 225.96844846753726)));
        /*0.44435544985946895*/
    }

    public static void alpha124() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 4000.0}, new Quaternion(2268.3769469760687,
                new Vector(84.13821053262355, 163.30969175041088, 182.48805046374605)));
        /*0.5378731541347116*/
    }

    public static void alpha125() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 5000.0}, new Quaternion(2425.575340294634,
                new Vector(90.04412661380373, 174.9178513179466, 193.53082536093697)));
        /*0.631005289929338*/
    }

    public static void alpha126() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 6000.0}, new Quaternion(1278.5812896465577,
                new Vector(47.00200456722386, 90.3811191304896, 94.49233595696062)));
        /*0.7237495719395564*/
    }

    public static void alpha127() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 7000.0}, new Quaternion(1579.0626062055026,
                new Vector(58.29049506203102, 112.57161309132204, 117.64948948946918)));
        /*0.8161023547512606*/
    }

    public static void alpha128() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 8000.0}, new Quaternion(494.5099184992064,
                new Vector(17.59670049666635, 32.657087444152104, 23.90184539032864)));
        /*0.9080588213038621*/
    }

    public static void alpha129() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 9000.0}, new Quaternion(431.86497935685674,
                new Vector(15.260648005808623, 28.094101882840988, 16.4270466113912)));
        /*0.9996130262325005*/
    }

    public static void alpha1210() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 2000.0, 10000.0}, new Quaternion(506.38793906429714,
                new Vector(18.075309331983906, 33.65356991996825, 20.5419279185773)));
        /*1.0907578924280608*/
    }

    public static void alpha111() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 1000.0, 1000.0}, new Quaternion(-5966.385416483641,
                new Vector(-224.94022394299915, -441.85403866404124, -505.8969868548149)));
        /*0.18455058244466496*/
    }

    public static void alpha133() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 3000.0, 3000.0}, new Quaternion(1,
                new Vector(1, 2, 3)));
        /*0.5163281860856808*/
    }

    public static void alpha144() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 4000.0, 4000.0}, new Quaternion(5764.766955037214,
                new Vector(215.36332417689115, 417.14115605786554, 477.6021824551349)));
        /*0.6821975645883387*/
    }

    public static void alpha155() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 5000.0, 5000.0}, new Quaternion(9191.429266504492,
                new Vector(343.97642235719155, 667.8097373607136, 764.6030212647986)));
        /*0.8480643431827684*/
    }

    public static void alpha166() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 6000.0, 6000.0}, new Quaternion(-10824.381714826033,
                new Vector(-407.27943577535285, -809.8638708449568, -927.246686513782)));
        /*1.0139298219178696*/
    }

    public static void alpha177() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 7000.0, 7000.0}, new Quaternion(9538.361857233258,
                new Vector(356.99764333900464, 689.4504588905198, 789.3803783971281)));
        /*1.1797945575930033*/
    }

    public static void alpha188() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 8000.0, 8000.0}, new Quaternion(4113.647623051936,
                new Vector(153.39114986182682, 287.5340182080929, 329.2096007766977)));
        /*1.3456588291157578*/
    }

    public static void alpha199() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 9000.0, 9000.0}, new Quaternion(-4217.115016788839,
                new Vector(-159.28837352039952, -328.6365226950098, -376.26956881383427)));
        /*1.5115227892739374*/
    }

    public static void alpha1000() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{1000.0, 10000.0, 10000.0}, new Quaternion(8877.458302300043,
                new Vector(332.1916950324511, 634.8177480153502, 726.8291235741827)));
        /*1.6773865337492355*/
    }

    public static void alpha222() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{2000.0, 2000.0, 2000.0}, new Quaternion(-4353.585837775107,
                new Vector(-165.41003228207435, -324.91783602877894, -372.0118859144671)));
        /*0.3691011649278124*/
    }

    public static void alpha333() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{3000.0, 3000.0, 3000.0}, new Quaternion(12702.94314801907,
                new Vector(473.771418148164, 930.6375304646095, 1065.5254480408562)));
        /*0.5536517473623023*/
    }

    public static void alpha444() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{4000.0, 4000.0, 4000.0}, new Quaternion(4547.360769175066,
                new Vector(166.6638147172795, 327.38066291648465, 374.8316784094522)));
        /*0.7382023299085259*/
    }

    public static void alpha555() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{5000.0, 5000.0, 5000.0}, new Quaternion(-14033.78567730655,
                new Vector(-531.7476749673788, -1044.5213115559964, -1195.9157051505958)));
        /*0.9227529126527748*/
    }

    public static void alpha666() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{6000.0, 6000.0, 6000.0}, new Quaternion(-4212.6909758910315,
                new Vector(-164.13460547208322, -322.4124927154159, -369.14341459622915)));
        /*1.1073034950203156*/
    }

    public static void alpha777() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{7000.0, 7000.0, 7000.0}, new Quaternion(24688.34022527835,
                new Vector(919.6078986814283, 1806.4019715885854, 2068.224423697528)));
        /*1.2918540774575527*/
    }

    public static void alpha888() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{8000.0, 8000.0, 8000.0}, new Quaternion(4521.548902907088,
                new Vector(161.68221886909782, 317.59522656802795, 363.6279271008255)));
        /*1.4764046594125089*/
    }

    public static void alpha999() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{9000.0, 9000.0, 9000.0}, new Quaternion(-3970.5037696216095,
                new Vector(-158.0541625027192, -310.4685716239018, -355.46832473001115)));
        /*1.660955240413333*/
    }

    public static void alpha000() throws SizeException, NotResolvableNewtonMethodException, MultiplySideException, IndexException, IOException, ZeroException {
        la(300.0, new Double[]{10000.0, 10000.0, 10000.0}, new Quaternion(-11912.067807685153,
                new Vector(-457.1289911245754, -897.9465183153112, -1028.0961544347367)));
        /*1.8455058248796425*/
    }

}

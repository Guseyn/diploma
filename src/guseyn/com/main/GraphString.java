package guseyn.com.main;

import guseyn.com.exceptions.IndexException;
import guseyn.com.libs.Quaternion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GraphString {

    public static void $(double[] x, double[] y, String xV, String yV,
                         String xL, String yL, int md, boolean isTypeN, String filePath, boolean isUp) throws IOException {
        StringBuilder output = new StringBuilder("");
        StringBuilder xS = new StringBuilder(xV + "<-c(");
        StringBuilder yS = new StringBuilder(yV + "<-c(");
        DecimalFormat df = new DecimalFormat("#.##########");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i = 0; i < y.length; i += (md == 0) ? 1 : md) {
            xS.append(x[i]);
            if (isUp && y[i] <= 0) {
                y[i] += 360;
            }
            yS.append(df.format(y[i]));
            if (i < y.length - ((md == 0) ? 1 : md)) {
                xS.append(", ");
                yS.append(", ");
            }
        }
        output.append(xS).append(");\n").append(yS).append(");\n");
        output.append("plot(")
                .append(xV)
                .append(", ")
                .append(yV)
                .append(", xlab=\"")
                .append(xL)
                .append("\", ylab=\"")
                .append(yL).append("\"");
        if (isTypeN) {
            output.append(", type='n'");
        }
        output.append(");\n");
        output.append("lines(").append(xV).append(", ").append(yV).append(",  type='l');\ngrid();\n");
        File file = new File(filePath);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output.toString());
        bw.close();
    }

    public static void $$(Quaternion[] solution, String filePath, double step, boolean index,
                          int missingDots, double min, double max, String text) throws IndexException, IOException {

        double[] s = new double[solution.length];
        double[] v1 = new double[solution.length];
        double[] v2 = new double[solution.length];
        double[] v3 = new double[solution.length];

        DecimalFormat df = new DecimalFormat("#.##########");
        df.setRoundingMode(RoundingMode.CEILING);

        StringBuilder output = new StringBuilder("");
        StringBuilder t = new StringBuilder("t<-c(");
        StringBuilder q0 = new StringBuilder("q0<-c(");
        StringBuilder q1 = new StringBuilder("q1<-c(");
        StringBuilder q2 = new StringBuilder("q2<-c(");
        StringBuilder q3 = new StringBuilder("q3<-c(");
        for (int i = 0; i < solution.length; i += missingDots) {
            s[i] = solution[i].get(0);
            v1[i] = solution[i].get(1);
            v2[i] = solution[i].get(2);
            v3[i] = solution[i].get(3);

            t.append(df.format(i * step));
            q0.append(df.format(s[i]));
            q1.append(df.format(v1[i]));
            q2.append(df.format(v2[i]));
            q3.append(df.format(v3[i]));

            if (i < solution.length - missingDots) {
                t.append(", ");
                q0.append(", ");
                q1.append(", ");
                q2.append(", ");
                q3.append(", ");
            }
        }

        output
                .append(t)
                .append(");\n")
                .append(q0)
                .append(");\n")
                .append(q1)
                .append(");\n")
                .append(q2)
                .append(");\n")
                .append(q3)
                .append(");\n");
        if (index) {
            output.append("plot(t, q0, ylim=c(")
                    .append(min).append(", ").append(max)
                    .append("), type='n');\n");
        }
        output.append("plot(t, q1, ylab='', xlab='t', ylim=c(")
                .append(min).append(", ").append(max)
                .append("), type='n');\n")
                .append("plot(t, q2, ylab='', xlab='t', ylim=c(")
                .append(min).append(", ").append(max)
                .append("), type='n');\n")
                .append("plot(t, q3, ylab='', xlab='t', ylim=c(")
                .append(min).append(", ").append(max)
                .append("), type='n');\n");
        if (index) {
            output.append("lines(t, q0, type='l');\n");
        }
        output.append("lines(t, q1, type='l');\n")
                .append("lines(t, q2, type='l');\n")
                .append("lines(t, q3, type='l');\n")
                .append(text).append(";\n")
                .append("grid();\n");

        File file = new File(filePath);

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output.toString());
        bw.close();


    }

}


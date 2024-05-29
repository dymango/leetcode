package leetcodepractice.leetcode;

import java.util.Random;

/**
 * @author dimmy
 */
public class Solution_478 {
    double radius;
    double x_center;
    double y_center;
    public Solution_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double side = radius*2;
        while(true) {
            double x = new Random().nextDouble() * side + (x_center - radius);
            double y = new Random().nextDouble() * side + (y_center - radius);
            double xToCenter = Math.abs(x_center - x);
            double yToCenter = Math.abs(y_center - y);
            if(Math.sqrt(xToCenter*xToCenter + yToCenter*yToCenter) <= radius) return new double[]{x, y};
        }
    }

    /**
     * double rad, xc, yc;
     *     public Solution(double radius, double x_center, double y_center) {
     *         rad = radius;
     *         xc = x_center;
     *         yc = y_center;
     *     }
     *
     *     public double[] randPoint() {
     *         double d = rad * Math.sqrt(Math.random());
     *         double theta = Math.random() * 2 * Math.PI;
     *         return new double[]{d * Math.cos(theta) + xc, d * Math.sin(theta) + yc};
     *     }
     */
}

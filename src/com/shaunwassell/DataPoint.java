package com.shaunwassell;

public class DataPoint {
    public final Float x;
    public final Float y;
    public final String label;

    public static Float getSquaredDistance(DataPoint dp1, DataPoint dp2) {
        Float xDistance = dp1.x - dp2.x;
        Float yDistance = dp1.y - dp2.y;

        return xDistance * xDistance + yDistance * yDistance;
    }

    public DataPoint(Float x, Float y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }
}

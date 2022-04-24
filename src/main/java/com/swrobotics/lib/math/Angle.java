package com.swrobotics.lib.math;

public final class Angle {
    public static Angle cwRad(double angle) {
        return new Angle(-angle);
    }

    public static Angle ccwRad(double angle) {
        return new Angle(angle);
    }

    public static Angle cwDeg(double angle) {
        return new Angle(Math.toRadians(-angle));
    }

    public static Angle ccwDeg(double angle) {
        return new Angle(Math.toRadians(angle));
    }

    private double angle;

    private Angle(double angle) {
        this.angle = angle;
    }

    public double getCWRad() {
        return -angle;
    }

    public double getCCWRad() {
        return angle;
    }

    public double getCWDeg() {
        return Math.toDegrees(-angle);
    }

    public double getCCWDeg() {
        return Math.toDegrees(-angle);
    }

    private double normalize(double value, double min, double max) {
        double width = max - min;
        double offset = value - min;

        return (offset - Math.floor(offset / width) * width) + min;
    }

    public Angle normalizeRad(double min, double max) {
        return ccwRad(normalize(getCCWRad(), min, max));
    }

    public Angle normalizeDeg(double min, double max) {
        return ccwDeg(normalize(getCCWDeg(), min, max));
    }

    public Angle add(Angle o) {
        angle += o.angle;
        return this;
    }

    public Angle add(Angle o, Angle dest) {
        dest.angle = angle + o.angle;
        return dest;
    }

    public Angle sub(Angle o) {
        angle -= o.angle;
        return this;
    }

    public Angle sub(Angle o, Angle dest) {
        dest.angle = angle - o.angle;
        return dest;
    }
}

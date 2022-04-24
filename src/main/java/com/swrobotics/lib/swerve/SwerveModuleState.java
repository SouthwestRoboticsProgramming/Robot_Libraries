package com.swrobotics.lib.swerve;

import com.swrobotics.lib.math.Angle;

public final class SwerveModuleState {
    private final double velocity;
    private final Angle angle;

    public SwerveModuleState(double velocity, Angle angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    public double getVelocityMetersPerSecond() {
        return velocity;
    }

    public Angle getAngle() {
        return angle;
    }

    @Override
    public String toString() {
        return "SwerveModuleState{" +
                "velocity=" + velocity +
                ", angle=" + angle +
                '}';
    }
}

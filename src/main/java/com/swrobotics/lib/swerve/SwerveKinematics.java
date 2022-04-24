package com.swrobotics.lib.swerve;

import com.swrobotics.lib.math.Angle;
import com.swrobotics.lib.math.Vec2d;

public final class SwerveKinematics {
    private final Vec2d[] modulePositions;
    private final int moduleCount;
    private final double maxWheelSpeed;

    public SwerveKinematics(double maxWheelSpeed, Vec2d... modulePositions) {
        this.modulePositions = modulePositions;
        moduleCount = modulePositions.length;
        this.maxWheelSpeed = maxWheelSpeed;
    }

    public BodySpeed forward(SwerveModuleState... moduleStates) {
        // TODO: Implement this
        return null;
    }

    public SwerveModuleState[] inverse(BodySpeed targetSpeed) {
        Vec2d[] wheelVectors = new Vec2d[moduleCount];
        Vec2d translationVector = targetSpeed.getVelocity();
        for (int i = 0; i < moduleCount; i++) {
            Vec2d modulePos = modulePositions[i];

            double turnSpeed = modulePos.magnitude() * targetSpeed.getRotation().getCCWRad();
            Vec2d rotationVector = modulePos.normalize().mul(turnSpeed).rotateBy(Angle.ccwDeg(90));

            wheelVectors[i] = rotationVector.add(translationVector);
        }

        double maxMagnitude = 0;
        for (Vec2d vec : wheelVectors) {
            maxMagnitude = Math.max(maxMagnitude, vec.magnitude());
        }
        if (maxMagnitude > maxWheelSpeed) {
            double scale = maxWheelSpeed / maxMagnitude;
            for (Vec2d vec : wheelVectors) {
                vec.mul(scale);
            }
        }

        SwerveModuleState[] states = new SwerveModuleState[moduleCount];
        for (int i = 0; i < moduleCount; i++) {
            Vec2d vec = wheelVectors[i];

            double velocity = vec.magnitude();
            Angle angle = vec.angle();

            states[i] = new SwerveModuleState(velocity, angle);
        }
        return states;
    }
}

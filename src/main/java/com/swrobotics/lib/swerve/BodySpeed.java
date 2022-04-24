package com.swrobotics.lib.swerve;

import com.swrobotics.lib.math.Angle;
import com.swrobotics.lib.math.Vec2d;

public final class BodySpeed {
    private final Vec2d velocity;
    private final Angle rotation;

    /**
     * Creates a new BodySpeed object.
     * 
     * @param velocity Velocity in meters per second
     * @param rotation Rotation per second
     */
    public BodySpeed(Vec2d velocity, Angle rotation) {
        this.velocity = velocity;
        this.rotation = rotation;
    }

    public Vec2d getVelocity() {
        return velocity;
    }

    public Angle getRotation() {
        return rotation;
    }
}

package ball.model;

import ball.Ball;

import java.awt.*;
import java.util.ArrayList;

public class RealBall implements Ball {
    protected int x;
    protected int y;
    protected int radius;
    protected ArrayList<BallBehavior> ballBehaviors;

    protected RealBall(int x, int y, int radius, ArrayList<BallBehavior> ballBehaviors) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.ballBehaviors = ballBehaviors;
    }

    protected RealBall(int x, int y, ArrayList<BallBehavior> ballBehaviors) {
        this(x, y, DEFAULT_RADIUS, ballBehaviors);
    }

    public Point center() {
        return new Point(x, y);
    }

    public void update() {
        for (BallBehavior ballBehavior : ballBehaviors) {
            ballBehavior.update(this);
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

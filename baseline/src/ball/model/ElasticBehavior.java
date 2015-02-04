package ball.model;

import ball.Ball;

public class ElasticBehavior implements BallBehavior {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection = SHRINK;

    private RealBall elasticBall;

    @Override
    public void update(RealBall ball) {
        elasticBall = ball;
        growthDirection = reverseGrowthDirectionIfNecessary();
        elasticBall.setRadius(next());
    }

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return elasticBall.getRadius() <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return elasticBall.getRadius() >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return elasticBall.getRadius() + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}

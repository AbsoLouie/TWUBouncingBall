package ball.model;

import ball.Ball;

import java.util.ArrayList;

public class BallFactory {

    static BallBehavior bouncing = new BouncingBehavior();
    static BallBehavior elastic = new ElasticBehavior();

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS),
                bouncingElasticBall(500, 100, Ball.DEFAULT_RADIUS)};
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius) {
        ArrayList<BallBehavior> ballBehaviors = new ArrayList<BallBehavior>();
        ballBehaviors.add(bouncing);
        ballBehaviors.add(elastic);
        return new RealBall(centerX, centerY, radius, ballBehaviors);
    }

    public static Ball bouncingBall(int centerX, int centerY) {
        ArrayList<BallBehavior> ballBehaviors = new ArrayList<BallBehavior>();
        ballBehaviors.add(bouncing);
        return new RealBall(centerX, centerY, ballBehaviors);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius) {
        ArrayList<BallBehavior> ballBehaviors = new ArrayList<BallBehavior>();
        ballBehaviors.add(elastic);
        return new RealBall(centerX, centerY, radius, ballBehaviors);
    }
}

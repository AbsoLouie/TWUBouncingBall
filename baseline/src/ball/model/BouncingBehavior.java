package ball.model;

import ball.ui.BallWorld;

public class BouncingBehavior implements BallBehavior{

    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;
    private RealBall bouncingBall;
    int direction;

    public BouncingBehavior() {
        this.direction = DOWN;
    }

    @Override
    public void update(RealBall ball) {
        bouncingBall = ball;
        direction = reverseDirectionIfNecessary();
        bouncingBall.setY(move());
    }

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return bouncingBall.getY() + bouncingBall.getRadius() >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return bouncingBall.getY() - bouncingBall.getRadius() <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return bouncingBall.getY() + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }

}

package ball.model;

import ball.Ball;
import ball.ui.BallWorld;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BouncingBehaviorTest {

    private RealBall bouncingBall;
    private BouncingBehavior bouncingBehavior;

    @Before
    public void setUp() throws Exception {
        bouncingBall = mock(RealBall.class);
        bouncingBehavior = new BouncingBehavior();
    }

    @Test
    public void shouldGoDown() {
        when(bouncingBall.getY()).thenReturn(0);
        when(bouncingBall.getRadius()).thenReturn(Ball.DEFAULT_RADIUS);

        bouncingBehavior.update(bouncingBall);
        verify(bouncingBall).setY(bouncingBehavior.MOVEMENT_SPEED);
    }

    @Test
    public void shouldGoUp() {
        when(bouncingBall.getY()).thenReturn(BallWorld.BOX_HEIGHT);
        when(bouncingBall.getRadius()).thenReturn(Ball.DEFAULT_RADIUS);

        bouncingBehavior.update(bouncingBall);
        verify(bouncingBall).setY(BallWorld.BOX_HEIGHT - bouncingBehavior.MOVEMENT_SPEED);
    }
}
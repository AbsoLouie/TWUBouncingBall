package ball.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RealBallTest {
    @Test
    public void testUpdate() throws Exception {
        BallBehavior ballBehavior = mock(BallBehavior.class);
        RealBall ball = new RealBall(100, 100, 100, new ArrayList<BallBehavior>(Arrays.asList(ballBehavior)));

        ball.update();

        verify(ballBehavior).update(ball);
    }
}
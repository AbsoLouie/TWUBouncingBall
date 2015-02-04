package ball.model;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ElasticBehaviorTest {

    private RealBall elasticBall;
    private ElasticBehavior elasticBehavior;

    @Before
    public void setUp() throws Exception {
        elasticBall = mock(RealBall.class);
        elasticBehavior = new ElasticBehavior();
    }

    @Test
    public void shouldDecreaseRadius() {
        when(elasticBall.getRadius()).thenReturn(elasticBall.DEFAULT_RADIUS);

        elasticBehavior.update(elasticBall);
        verify(elasticBall).setRadius(elasticBall.DEFAULT_RADIUS - elasticBehavior.GROWTH_RATE);
    }

    @Test
    public void shouldIncreaseRadius() {
        when(elasticBall.getRadius()).thenReturn(0);

        elasticBehavior.update(elasticBall);
        verify(elasticBall).setRadius(elasticBehavior.GROWTH_RATE);
    }
}

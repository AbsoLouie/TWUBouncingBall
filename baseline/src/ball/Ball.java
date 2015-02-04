package ball;

import java.awt.*;

// DO NOT CHANGE (but you can add methods)
public interface Ball {
    int DEFAULT_RADIUS = 50;

    Point center();

    void update();

    int getRadius();
}

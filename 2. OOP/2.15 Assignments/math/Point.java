package math;

import java.io.IOException;

public interface Point {
	
    void loadCoordinates() throws IOException;

    void isPointUnitVector();

    void isPointOnCoordAxis();

    void savePoint();
}
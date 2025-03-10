/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest
{
    @Test
        // Tests method getY that returns the y
    void getY()
    {
        Position p = new Position(2,4);

        assertEquals(4,p.getY());
    }

    @Test
    // Tests method getY that returns the X
    void getX()
    {
        Position p = new Position(2,4);

        assertEquals(2,p.getX());
    }

}

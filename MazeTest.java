/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeTest
{
    @Test
        // Tests method getStart
    void getStart() throws IOException
    {
        Reader r = null;
        try
        {
            r = new FileReader("Maze.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }

        Maze maze = new Maze(r);
        Position p = maze.getStart();
        assertEquals(true, maze.isMovable(p));

    }
}

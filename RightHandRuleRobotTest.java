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

public class RightHandRuleRobotTest
{
    @Test
        // Tests method move
    void move() throws IOException
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
        RightHandRuleRobot robot = new RightHandRuleRobot(maze);
        Position p = maze.getStart();
        robot.setPosition(p);
        robot.move();
        assertEquals(false,p.equals(robot.getPosition()));

    }
}
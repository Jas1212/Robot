/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;


public class RandomRobot implements Robot
{
    private Position position;
    private Position previousPosition;
    private Maze maze;
    private Stack<Position> posStack;
    private DijkstraRobot.QueueElm q = null;






    /**
     * RandomRobot Constructor
     * @param m - The maze
     */
    public  RandomRobot(Maze m)
    {
        maze = m;
        position = maze.getStart();
        posStack = new Stack<Position>();
        maze.initializeVisited();
    }

    /**
     * Method to move the position in the maze
     * @return - nothing
     */
    public void move()
    {
        ArrayList<Direction> Dirs = new ArrayList<Direction>();
        Dirs.add(Direction.North);
        Dirs.add(Direction.East);
        Dirs.add(Direction.West);
        Dirs.add(Direction.South);
        Collections.shuffle(Dirs);

        Position p1 = position.getPosToDir(Dirs.get(0));
        Position p2 = position.getPosToDir(Dirs.get(1));
        Position p3 = position.getPosToDir(Dirs.get(2));
        Position p4 = position.getPosToDir(Dirs.get(3));


        if(maze.isMovable(p1) && !maze.hasVisited(p1))
        {
            posStack.push(position);
            setPosition(p1);
            maze.setVisited(p1);
        }
        else if(maze.isMovable(p2) && !maze.hasVisited (p2))
        {
            posStack.push(position);
            setPosition(p2);
            maze.setVisited(p2);
        }
        else if(maze.isMovable(p3) && !maze.hasVisited(p3))
        {
            posStack.push(position);
            setPosition(p3);
            maze.setVisited(p3);
        }
        else if(maze.isMovable(p4) && !maze.hasVisited(p4))
        {
            posStack.push(position);
            setPosition(p4);
            maze.setVisited(p4);
        }
        else
        {
            Position p = posStack.pop();
            setPosition(p);
        }

    }

    /**
     * Method to get the position
     * @return - the position
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * Method to set a position
     * @return - nothing a void
     */
    public void setPosition(Position p)
    {
        previousPosition = position;
        position = p;
    }

    /**
     * Method to check if one has reached the goal
     * @return - tru if one has, false if not
     */
    public boolean hasReachedGoal()
    {
        return maze.isGoal(position);
    }

    public boolean hasReachedStart()
    {
        return maze.isStart(position);

    }
    public DijkstraRobot.QueueElm getQ()
    {
        return q;
    }

}

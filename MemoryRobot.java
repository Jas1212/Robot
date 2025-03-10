/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

import java.util.Stack;

public class MemoryRobot implements Robot
{
    private Position position;
    private Position previousPosition;
    private Maze maze;
    private Stack<Position> posStack;
    private DijkstraRobot.QueueElm q = null;


    /**
     * MemoryRobot Constructor
     * @param m - The maze
     */
    public  MemoryRobot(Maze m)
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
        Position n = position.getPosToNorth();
        Position w = position.getPosToWest();
        Position e = position.getPosToEast();
        Position s = position.getPosToSouth();

        if(maze.isMovable(e) && !maze.hasVisited(e))
        {
            posStack.push(position);
            setPosition(e);
            maze.setVisited(e);
        }
        else if(maze.isMovable(w) && !maze.hasVisited (w))
        {
            posStack.push(position);
            setPosition(w);
            maze.setVisited(w);
        }
        else if(maze.isMovable(n) && !maze.hasVisited(n))
        {
            posStack.push(position);
            setPosition(n);
            maze.setVisited(n);
        }
        else if(maze.isMovable(s) && !maze.hasVisited(s))
        {
            posStack.push(position);
            setPosition(s);
            maze.setVisited(s);
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

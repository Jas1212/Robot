/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

/**
 * Possible directions in the maze
 *
 */

public class RightHandRuleRobot implements Robot
{
    private Position position;
    private Position previousPosition;
    private Maze maze;
    private Direction dir = Direction.Undefined;
    private DijkstraRobot.QueueElm q = null;


    /**
     * RightHandRuleRobot Constructor
     * @param m - The maze
     */
    public  RightHandRuleRobot(Maze m)
    {
        maze = m;
        position = maze.getStart();
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

        if(dir == Direction.Undefined)
        {
            if(maze.isMovable(n) && !maze.isMovable(e))
            {
                dir = Direction.North;
            }
            else if(maze.isMovable(e) && !maze.isMovable(s))
            {
                dir = Direction.East;
            }
            else if(maze.isMovable(s) && !maze.isMovable(w))
            {
                dir = Direction.South;
            }
            else if(maze.isMovable(w) && !maze.isMovable(n))
            {
                dir = Direction.West;
            }

        }

        if(dir == Direction.North)
        {
            if(maze.isMovable(e))
            {
                setPosition(e);
                dir = Direction.East;
            }
            else if (maze.isMovable(n))
            {
                setPosition(n);
                dir = Direction.North;

            }
            else if(maze.isMovable(w))
            {
                setPosition(w);
                dir = Direction.West;

            }
            else if(maze.isMovable(s))
            {
                setPosition(s);
                dir = Direction.South;
            }
        }
        else if(dir == Direction.East)
        {
            if(maze.isMovable(s))
            {
                setPosition(s);
                dir = Direction.South;
            }
            else if (maze.isMovable(e))
            {
                setPosition(e);
                dir = Direction.East;

            }
            else if(maze.isMovable(n))
            {
                setPosition(n);
                dir = Direction.North;

            }
            else if(maze.isMovable(w))
            {
                setPosition(w);
                dir = Direction.West;
            }
        }
        else if(dir == Direction.West)
        {
            if(maze.isMovable(n))
            {
                setPosition(n);
                dir = Direction.North;
            }
            else if (maze.isMovable(w))
            {
                setPosition(w);
                dir = Direction.West;

            }
            else if(maze.isMovable(s))
            {
                setPosition(s);
                dir = Direction.South;

            }
            else if(maze.isMovable(e))
            {
                setPosition(e);
                dir = Direction.East;
            }
        }
        else if(dir == Direction.South)
        {
            if(maze.isMovable(w))
            {
                setPosition(w);
                dir = Direction.West;
            }
            else if (maze.isMovable(s))
            {
                setPosition(s);
                dir = Direction.South;

            }
            else if(maze.isMovable(e))
            {
                setPosition(e);
                dir = Direction.East;

            }
            else if(maze.isMovable(n))
            {
                setPosition(n);
                dir = Direction.North;
            }
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

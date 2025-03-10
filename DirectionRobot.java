/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

import java.util.Stack;

public class DirectionRobot implements Robot
{

    private Position position;
    private Position previousPosition;
    private Maze maze;
    private Stack<Position> posStack;
    private DijkstraRobot.QueueElm q = null;


    /**
     * DirectionRobot Constructor
     * @param m - The maze
     */
    public DirectionRobot(Maze m)
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
        double d = 0; double minD = Double.MAX_VALUE;
        Position bestP = null;


        if(maze.isMovable(e) && !maze.hasVisited(e))
        {
            d = Distance(e);
            if(d < minD)
            {
                minD = d;
                bestP = e;
            }

        }
         if(maze.isMovable(w) && !maze.hasVisited (w))
        {
            d = Distance(w);
            if(d < minD)
            {
                minD = d;
                bestP = w;
            }
        }
         if(maze.isMovable(n) && !maze.hasVisited(n))
        {
            d = Distance(n);
            if(d < minD)
            {
                minD = d;
                bestP = n;
            }
        }
         if(maze.isMovable(s) && !maze.hasVisited(s))
        {
            d = Distance(s);
            if(d < minD)
            {
                minD = d;
                bestP = s;
            }
        }


        if(bestP != null)
        {
            posStack.push(position);
            setPosition(bestP);
            maze.setVisited(bestP);
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

    public double Distance(Position p1)
    {
        Position p2 = maze.getGoal();
        return Math.sqrt((p2.getY() - p1.getY()) * (p2.getY() - p1.getY()) + (p2.getX() - p1.getX()) * (p2.getX() - p1.getX()));
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

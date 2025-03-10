/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

import java.util.*;


public class DijkstraRobot implements Robot
{

    private Position position;
    private Position previousPosition;
    private Maze maze;
    private double d = 0;
    private PriorityQueue<QueueElm> pq;
    private QueueElm q = null;

    /**
     * DirectionRobot Constructor
     * @param m - The maze
     */
    public DijkstraRobot(Maze m)
    {
        maze = m;
        position = maze.getStart();
        maze.initializeVisited();
        pq = new PriorityQueue<QueueElm>(10, new PqComparator());
        pq.add(new QueueElm(position,d,null));
    }



    /**
     * Method to move the position in the maze
     * @return - nothing
     */
    public void move()
    {
        QueueElm qe = pq.poll();
        position = qe.p;
        q = qe;
        Neighbours(qe);
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

    private void Neighbours(QueueElm QU)
    {
        if(maze.isMovable(QU.p.getPosToEast()) && !maze.hasVisited(QU.p.getPosToEast()))
        {
            QueueElm eq = new QueueElm(QU.p.getPosToEast(),d + 1,QU);
            maze.setVisited(QU.p);
            pq.add(eq);
        }

        if(maze.isMovable(QU.p.getPosToWest()) && !maze.hasVisited(QU.p.getPosToWest()))
        {
            QueueElm eq = new QueueElm(QU.p.getPosToWest(),d + 1,QU);
            maze.setVisited(QU.p);
            pq.add(eq);
        }

        if(maze.isMovable(QU.p.getPosToNorth()) && !maze.hasVisited(QU.p.getPosToNorth()))
        {
            QueueElm eq = new QueueElm(QU.p.getPosToNorth(),d + 1,QU);
            maze.setVisited(QU.p);
            pq.add(eq);
        }

        if(maze.isMovable(QU.p.getPosToSouth()) && !maze.hasVisited(QU.p.getPosToSouth()))
        {
            QueueElm eq = new QueueElm(QU.p.getPosToSouth(),d + 1,QU);
            maze.setVisited(QU.p);
            pq.add(eq);
        }

    }

    public DijkstraRobot.QueueElm getQ()
    {
        return q;
    }


    public boolean hasReachedStart()
    {
        return maze.isStart(position);
    }


    class PqComparator implements Comparator<QueueElm>
{
    public int compare(QueueElm d1, QueueElm d2)
    {
        if (d1.d < d2.d)
            return -1;
        else if (d1.d > d2.d)
            return 1;
        return 0;
    }
}
    class QueueElm
    {
        public Position p;
        public double d;
        public QueueElm prevp;

        public QueueElm(Position p, double d, QueueElm prevp)
        {
            this.p = p;
            this.d = d;
            this.prevp = prevp;
        }
    }
}


/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

/**
 * This interface is commonly shared between the robot classes.
 */

enum Direction {
    North,
    East,
    West,
    South,
    Undefined
}
public interface Robot
{
    public void move();
    public Position getPosition();
    public void setPosition(Position p);
    public boolean hasReachedGoal();
    public boolean hasReachedStart();
    public DijkstraRobot.QueueElm getQ();





}

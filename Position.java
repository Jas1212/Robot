/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

public class Position
{
    private int x;
    private int y;

    /**
     * Position Constructor
     * @param x - The Position x-coordinate
     * @param y - The Position y-coordinate
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to get a move the position south
     * @return - the moved position
     */
    public Position getPosToSouth()
    {
        Position p = new Position(x , y + 1);
        return p;
    }

    /**
     * Method to get a move the position north
     * @return - the moved position
     */
    public Position getPosToNorth()
    {
        Position p = new Position(x , y - 1);
        return p;
    }

    /**
     * Method to get a move the position west
     * @return - the moved position
     */
    public Position getPosToWest()
    {
        Position p = new Position(x - 1, y );
        return p;
    }

    /**
     * Method to get a move the position east
     * @return - the moved position
     */
    public Position getPosToEast()
    {
        Position p = new Position(x + 1, y );
        return p;
    }

    public  Position getPosToDir(Direction d)
    {
        Position newPos = null;

        switch(d)
        {
            case North:
                newPos = getPosToNorth();
                break;
            case East:
                newPos=  getPosToEast();
                break;
            case West:
                newPos =  getPosToWest();
                break;
            case South:
                newPos = getPosToSouth();
                break;
        }
        return newPos;
    }

    /**
     * Method to check if a two positions are the same
     * @return - true if they are the same, false if the position doesnt exist
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof Position))
        {
            return false;
        }
        Position p = (Position)o;

        return p.x == x && p.y == y;
    }

    public int hashCode()
    {
        return (x << 16) | y;

    }

    /**
     * Method to return the y-coordinate
     * @return - y-coordinate
     */
    public int getY()
    {
        return y;
    }

    /**
     * Method to return the x-coordinate
     * @return - x-coordinate
     */
    public int getX()
    {
        return x;
    }
}

/**
 * @author - dv19jhd
 * @date - 2020-06-07
 * @version - v1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Maze
{
    private ArrayList<String> mazeData;
    private boolean [][] visited;

    /**
     * Maze Constructor
     * @param a - the file that needs reading
     */
    public Maze(Reader a) throws IOException
    {
        BufferedReader br = new BufferedReader(a);
        mazeData = new ArrayList<>();
        while(br.ready())
        {
            mazeData.add(br.readLine());
        }
    }

    /**
     * Method to check if one move the position
     * @return - true if one can, false if one cant
     */
    public boolean isMovable(Position c)
    {
        if(c.getX() < 0 || c.getX() >= getNumColumns() || c.getY() < 0 || c.getY() >= getNumRows())
        {
            return false;
        }
        else if(isGoal(c))
        {
            return true;
        }
        else if(getStart().equals(c))
        {
            return true;
        }
        return mazeData.get(c.getY()).charAt(c.getX()) == ' ';
    }

    /**
     * Method to check if the position is Goal
     * @return - true if it is, false if it isnt
     */
    public boolean isGoal(Position f)
    {
        return mazeData.get(f.getY()).charAt(f.getX()) == 'G';
    }

    public boolean isStart(Position f)
    {
        return mazeData.get(f.getY()).charAt(f.getX()) == 'S';
    }

    /**
     * Method to get start position from the maze
     * @return - the position
     */
    public Position getStart()
    {
        for(int i = 0; i < getNumRows(); i++)
        {
            for(int j = 0; j < getNumColumns(); j++)
            {

                if(mazeData.get(i).charAt(j) == 'S')
                {
                    return new Position(j,i);
                }

            }
        }
        return null;
    }

    /**
     * Method to get goal position from the maze
     * @return - the position
     */
    public Position getGoal()
    {
        for(int i = 0; i < getNumRows(); i++)
        {
            for(int j = 0; j < getNumColumns(); j++)
            {

                if(mazeData.get(i).charAt(j) == 'G')
                {
                    return new Position(j,i);
                }

            }
        }
        return null;
    }

    /**
     * Method to get the number of columns in the maze
     * @return - the columns
     */
    public int getNumColumns()
    {
        return mazeData.get(0).length();

    }

    /**
     * Method to get the number of rows in the maze
     * @return - the rows
     */
    public int getNumRows()
    {
        return mazeData.size();

    }

    /**
     * Method to check if a position has been at position before
     * @return - true if it has, false if it hasnt
     */
    public boolean hasVisited(Position p)
    {
        if(visited == null)
        {
            visited = new boolean[getNumRows()][getNumColumns()];
        }
        return visited[p.getY()][p.getX()];
    }

    /**
     * Method to set a position in stack
     * @return - nothing is a void
     */
    public void setVisited(Position p)
    {
        if(visited == null)
        {
            visited = new boolean[getNumRows()][getNumColumns()];
        }
        visited[p.getY()][p.getX()] = true;
    }

    /**
     * Method to initialize the visited array to false
     * @return - nothing is a void
     */
    public void initializeVisited()
    {
        if(visited == null)
        {
            visited = new boolean[getNumRows()][getNumColumns()];
        }

        for(int i = 0; i < getNumRows(); i++)
        {
            for(int j = 0; j < getNumColumns(); j++)
            {
                visited[i][j] = false;

            }
        }
    }
}
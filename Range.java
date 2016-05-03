import java.util.Random;

/**
 * Write a description of class Range here.
 * 
 * @author Jay Rixie
 * @version 5/3/16
 */
public class Range
{
    /** description of instance variable x (add comment for each instance variable) */
    private int max;
    private int min;

    /**
     * Default constructor for objects of class Range
     */
    public Range(int mi, int ma)
    {
        min = mi;
        max = ma;
    }

    
    public int roll()
    {
        Random r1 = new Random();
        
        return r1.nextInt(max - min) + min;
    }

}

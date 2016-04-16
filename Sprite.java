import java.util.HashMap;
import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Write a description of class Sprite here.
 * 
 * @author Jay Rixie 
 * @version 4/15/16
 */
public class Sprite
{
    /** String name     Item's name
        HashMap attrib  HashMap containing strength, dexterity, constitution, intelligence, wisdom, and charisma integers
        Image img       Sprite's image*/
    private String name;
    private HashMap<String, Integer> attrib;
    private Image img;

    /**
     * Default constructor for objects of class Sprite
     */
    public Sprite()
    {
    }

    /**
     * Used to retrieve attrib HashMap
     * 
     * @return    returns attribute HashMap
     */
    public HashMap<String, Integer> getAttrib()
    {
        return attrib;
    }
    
    public void draw(Graphics2D g1, int x, int y)
    {
        g1.drawImage(img, x, y, null);
    }
}

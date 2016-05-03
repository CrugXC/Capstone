import java.util.HashMap;
import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Write a description of class ItemSprite here.
 * 
 * @author Jay Rixie 
 * @version 4/15/16
 */
public class ItemSprite extends Sprite
{
    /** String name     Item's name
        HashMap attrib  HashMap containing strength, dexterity, constitution, intelligence, wisdom, and charisma integers*/
    private String name;
    private HashMap<String, Integer> attrib;
    

    /**
     * Default constructor for objects of class ItemSprite
     */
    public ItemSprite()
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
    
    
}

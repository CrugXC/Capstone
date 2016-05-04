import java.util.HashMap;
import java.awt.Image;

/**
 * Write a description of class Weapon here.
 * 
 * @author Jay Rixie
 * @version 5/5/16
 */
public class Armor extends ItemSprite
{
    /** description of instance variable x (add comment for each instance variable) */
    private int armorClass;

    /**
     * Default constructor for objects of class Weapon
     */
    public Armor(int ar,  String name,  HashMap attrib, Image img)
    {
        super(name, attrib, img);
        armorClass = ar;
    }
    
    public int getAC()
    {
        return armorClass;
    }
}

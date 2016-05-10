import java.util.HashMap;
import java.awt.image.BufferedImage;

/**
 * Write a description of class Weapon here.
 * 
 * @author Jay Rixie
 * @version 5/4/16
 */
public class Weapon extends ItemSprite
{
    /** description of instance variable x (add comment for each instance variable) */
    private AttackType damage;

    /**
     * Default constructor for objects of class Weapon
     */
    public Weapon(AttackType d, String name, HashMap attributes, BufferedImage img)
    {
        super(name, attributes, img);
        damage = d;
    }
    
    public String toString()
    {
        return "<html>Weapon Name: " + this.getName() + " Attack: " + damage + "<br> Attributes: " + this.getAttrib() + "</html>";
    }
}

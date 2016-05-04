import java.awt.Image;
import java.awt.Graphics2D;


/**
 * Write a description of class Sprite here.
 * 
 * @author Jay Rixie
 * @version 5/3/16
 */
public class Sprite
{
    /** Image img       ItemSprite's image */
    private Image img;

    /**
     * Default constructor for objects of class Sprite
     */
    public Sprite(Image img)
    {
        this.img = img;
    }

    public void draw(Graphics2D g1, int x, int y)
    {
        g1.drawImage(img, x, y, null);
    }

}

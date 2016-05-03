import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
/**
 * Write a description of class InvSlot here.
 * 
 * @author Jay Rixie 
 * @version 4/16/16
 */
public class InvSlot extends JPanel
{
    private ItemSprite item;
    private Dimension dim;
    private boolean active;
    /**
     * Constructor for objects of class InvSlot
     */
    public InvSlot()
    {
        active = false;
        dim = new Dimension(75, 75);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  Graphics g       draws lines
     *         boolean active   whether InvSlot is selected or not

     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        
        if(active){g2.setColor(Color.YELLOW);}
        else{g2.setColor(Color.BLACK);}
        
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Double(0, 0, 0, 75));
        g2.draw(new Line2D.Double(0, 76, 76, 76));
        g2.draw(new Line2D.Double(72.5, 72.5, 72.5, 0));
        g2.draw(new Line2D.Double(72.5, 0, 2.5, 0));
    }

    /**
     * An example of a method - replace this comment with your own
     * @return     returns ItemSprite item */
    public ItemSprite getItem()
    {
        return item;
    }
    
    /**
     * @pre     active is set to false
     * @post    active is set to true
     */
    public void activate()
    {
        active = true;
    }
    
    /**
     * @pre     active is set to true
     * @post    active is set to false
     */
    public void deactivate()
    {
        active = false;
    }
}

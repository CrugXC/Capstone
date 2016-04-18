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
    private Sprite item;
    private Dimension dim;
    /**
     * Constructor for objects of class InvSlot
     */
    public InvSlot()
    {
        dim = new Dimension(50, 50);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(dim);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  Graphics g       draws lines
     *         boolean active   whether InvSlot is selected or not

     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        
        //if(active){g2.setColor(Color.YELLOW);}
        //else{g2.setColor(Color.BLACK);}
        
        g2.draw(new Line2D.Double(0, 0, 0, 50));
        g2.draw(new Line2D.Double(0, 50, 50, 50));
        g2.draw(new Line2D.Double(50, 50, 50, 0));
        g2.draw(new Line2D.Double(50, 0, 0, 0));
    }

    /**
     * An example of a method - replace this comment with your own
     * @return     returns Sprite item */
    public Sprite getItem()
    {
        return item;
    }

}

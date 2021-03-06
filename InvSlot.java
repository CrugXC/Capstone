import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Point;
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
    private int space;
    /**
     * Constructor for objects of class InvSlot
     */
    public InvSlot(ItemSprite importItem, int importSpace)
    {
        active = false;      
        
        item = importItem;
        space = importSpace;
        
        this.setBackground(Color.WHITE);
        
        dim = new Dimension(75, 75);
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
        
        if(item != null)
        {
            item.draw((Graphics2D)g, 15, 15);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * @return     returns ItemSprite item */
    public ItemSprite getItem()
    {
        return item;
    }
    
    public ItemSprite takeItem()
    {
        ItemSprite temp = item;
        item = null;
        repaint();
        return temp;
    }
    
    public void addItem(ItemSprite importItem)
    {
        item = importItem; 
    }
    
    /**
     * @pre     active is set to false
     * @post    active is set to true
     */
    public void activate()
    {
        active = true;
        repaint();
    }
    
    /**
     * @pre     active is set to true
     * @post    active is set to false
     */
    public void deactivate()
    {
        active = false;
        repaint();
    }
    
    public boolean contains(int x, int y, Point origin, String sect)
    {
        int yOffset = 0;
        if(sect.equals("main"))
        {
            yOffset = 80;
        }
        return ((x >= origin.getX() && x <= origin.getX() + this.getSize().getWidth()) && (y >= origin.getY() + yOffset && y <= origin.getY() + this.getSize().getHeight() + yOffset));
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Write a description of class InventoryPanel here.
 * 
 * @author Jay Rixie 
 * @version 4/15/16
 */
public class InventoryPanel extends JPanel
{
    /** ArrayList<JPanel> invSlots      linked to all JPanel inventory slots
        ArrayList<ItemSprites> sAttList     ItemSprites whose index value correlates to what slot they are stored in*/
        
    private InvSlot[][] invHolder;
    
    private Dimension dim;
    
    private Inventory inv;
    
    int rows;
    int cols;
    /**
     * Default constructor for objects of class InventoryPanel
     */
    public InventoryPanel(Inventory importInv)
    {   
        inv = importInv;
        
        //For loop taken from: http://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
        rows = 9;
        cols = 5;

        int count = 0;
        
        invHolder = new InvSlot[rows][cols];
        setLayout(new GridLayout(rows,cols, 5, 5));
        
        for(int m = 0; m < rows; m++) {
           for(int n = 0; n < cols; n++) {
              invHolder[m][n] = new InvSlot(inv.getItem(count));
              count ++;
              
              add(invHolder[m][n]);
           }
        }
        
        //this.setPreferredSize(new Dimension(500, 250));
    }
   
    public Dimension getDim()
    {
        return dim;
    }
    
    public class clickLister implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
        }
        
        public void mouseEntered(MouseEvent e)
        {
        }
        
        public void mouseExited(MouseEvent e)
        {
        }
        
        public void mousePressed(MouseEvent e)
        {
        }
        
        public void mouseReleased(MouseEvent e)
        {
        }
    }
}

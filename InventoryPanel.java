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
    
    private GridLayout invLayout;
    
    int rows;
    int cols;
    /**
     * Default constructor for objects of class InventoryPanel
     */
    public InventoryPanel()
    {
        //For loop taken from: http://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
        rows = 9;
        cols = 5;

        
        invHolder = new InvSlot[rows][cols];
        setLayout(new GridLayout(rows,cols, 5, 5));
        
        for(int m = 0; m < rows; m++) {
           for(int n = 0; n < cols; n++) {
              invHolder[m][n] = new InvSlot();
              add(invHolder[m][n]);
           }
        }
        
        //this.setPreferredSize(new Dimension(500, 250));
    }
    


    /**
     * @return    returns counted HashMap of all ItemSprite stats
     */
    public HashMap<String, Integer> getAttrib()
    {
        HashMap<String, Integer> totalAtt = new HashMap<>();
        
        //Creates key values and initializes them to 0
        
        //Credit to Stack Overflow user Björn Kautler for helping me fix "unchecked or unsafe operations" compiler warning
        totalAtt.put("strength", 0);
        totalAtt.put("dexterity", 0);
        totalAtt.put("constitution", 0);
        totalAtt.put("intelligence", 0);
        totalAtt.put("wisdom", 0);
        totalAtt.put("charisma", 0);
        
        HashMap<String, Integer> sAtt;
        
        for(InvSlot[] s: invHolder)
        {
            for(InvSlot i: s)
            {
                //iterates through sAtts and counts their attributes
                sAtt = i.getItem().getAttrib();
                
                totalAtt.put("strength", totalAtt.get("strength") + sAtt.get("strength"));
                totalAtt.put("dexterity", totalAtt.get("dexterity") + sAtt.get("dexterity"));
                totalAtt.put("constitution", totalAtt.get("constitution") + sAtt.get("constitution"));
                totalAtt.put("intelligence", totalAtt.get("intelligence") + sAtt.get("intelligence"));
                totalAtt.put("wisdom", totalAtt.get("wisdom") + sAtt.get("wisdom"));
                totalAtt.put("charisma", totalAtt.get("charisma") + sAtt.get("charisma"));
            }
        }
        
        return totalAtt;
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

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
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

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
    private JPanel mainInvPanel;
    
    private JPanel topInvPanel;
    
    private Dimension dim;
    
    private Inventory mainInv;
    private Inventory topInv;
    
    private JLabel itemStats;
    
    int rows;
    int cols;
    /**
     * Default constructor for objects of class InventoryPanel
     */
    public InventoryPanel(Inventory importTopInv, Inventory importMainInv)
    {   
        mainInv = importMainInv;
        topInv = importTopInv;
                
        itemStats = new JLabel("<html>No<br>Item<br>Selected</html>");

        //For loop taken from: http://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
        rows = 8;
        cols = 5;
        
        mainInvPanel = new JPanel();
        
        topInvPanel = new JPanel();
        
        mainInvPanel.setLayout(new GridLayout(rows, cols, 5, 5));
        
        topInvPanel.setLayout(new GridLayout(1, 2, 50, 50));
        topInvPanel.add(topInv.getSlot(0));
        topInvPanel.add(topInv.getSlot(1));
        
        
        int count = 0;

        for(int i = 0; i < rows * cols; i++)
        {
            mainInvPanel.add(mainInv.getSlot(count));
            count++;
        }
        
        this.setLayout(new BorderLayout());
        
        this.add(topInvPanel, BorderLayout.NORTH);
        this.add(mainInvPanel, BorderLayout.CENTER);
        this.add(itemStats, BorderLayout.SOUTH);
        
        this.addMouseListener(new ClickListener());
    }
    
    public ItemSprite getItem(String area, int space)
    {
        if(area.equals("top"))
        {
            return topInv.getItem(space);
        }
        else if(area.equals("main"))
        {
            return mainInv.getItem(space);
        }
        
        return null;
    }
    
    public Dimension getDim()
    {
        return dim;
    }
    
    public class ClickListener implements MouseListener
    {
        private InvSlot selected;
        
        public void mouseClicked(MouseEvent e)
        {
            
            boolean found = false;
            if(selected == null)
            {
                for(InvSlot slot: topInv.getList())
                {
                    System.out.println("Coordinates " + e.getX() + " " + e.getY());
                    if(slot.contains(e.getX(), e.getY(), slot.getLocation(), "top") && !found)
                    {
                        selected = slot;
                        if(selected.getItem() != null)
                        {itemStats.setText(slot.getItem().toString());}
                        found = true;
                        slot.activate();
                        System.out.println("Found at Coordinates " + e.getX() + " " + e.getY());
                    }
                }
                
                if(!found)
                {
                    for(InvSlot slot: mainInv.getList())
                    {
                        if(slot.contains(e.getX(), e.getY(), slot.getLocation(), "main") && !found)
                        {
                            selected = slot;
                            if(selected.getItem() != null)
                            {itemStats.setText(slot.getItem().toString());}
                            found = true;
                            slot.activate();
                            System.out.println("Found at Coordinates " + e.getX() + " " + e.getY());
                        }
                    }
                }
            }
            
            else
            {
                for(InvSlot slot: topInv.getList())
                    {
                        if(slot.contains(e.getX(), e.getY(), slot.getLocation(), "top") && !found)
                        {
                            ItemSprite item = selected.takeItem();
                            selected.addItem(slot.takeItem());
                            slot.addItem(item);
                            
                            found = true;
                        }
                    }
                
                if(!found)
                {
                    for(InvSlot slot: mainInv.getList())
                    {
                        if(slot.contains(e.getX(), e.getY(), slot.getLocation(), "main"))
                        {
                            ItemSprite item = selected.takeItem();
                            selected.addItem(slot.takeItem());
                            slot.addItem(item);
                                
                            found = true;
                        }
                    }
                }
                
                selected.deactivate();
                selected = null;
                itemStats.setText("<html>No<br>Item<br>Selected</html>");
            }
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

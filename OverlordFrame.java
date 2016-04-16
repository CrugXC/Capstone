import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 * Write a description of class OverlordFrame here.
 * 
 * @author Jay Rixie 
 * @version 4/14/16
 */
public class OverlordFrame extends JFrame
{
    /** ButtonPanel buttonPanel     panel with all action based buttons */
    private ButtonPanel buttonPanel;
    private InventoryPanel invPanel;
    private PlayerStatsPanel statPanel;
    private MonsterPanel monstPanel;
    /**
     * Default constructor for objects of class OverlordFrame
     */
    public OverlordFrame()
    {
        buttonPanel = new ButtonPanel();
        invPanel = new InventoryPanel();
        statPanel = new PlayerStatsPanel(invPanel);
        monstPanel = new MonsterPanel();
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.ipady = 50;
        //c.fill = GridBagConstraints.BOTH;
        
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .1;
        c.weighty = .4;
        c.gridheight = 2;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(invPanel, c);
        
        
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = .4;
        c.weighty = .3;
        c.gridwidth = 2;
        c.gridheight = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        this.add(buttonPanel, c);
        
        
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = .1;
        c.weighty = .4;
        c.gridwidth = 0;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(statPanel, c);
        
        
        c.gridx = 1;
        c.weightx = .4;
        c.weighty = .4;
        c.anchor = GridBagConstraints.CENTER;
        this.add(monstPanel, c);
        
        
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void sampleMethod(int y)
    {
    }
    
    public static void main(String[] args)
    {
        //Creates DrawingEditor
        OverlordFrame frame = new OverlordFrame();
    }

}

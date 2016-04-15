import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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

    /**
     * Default constructor for objects of class OverlordFrame
     */
    public OverlordFrame()
    {
        buttonPanel = new ButtonPanel();
        
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 5;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 3;
        c.gridy = 3;
        this.add(buttonPanel, c);
        
        this.setSize(960, 540);
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

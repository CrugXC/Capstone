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
    private InformationPanel infPanel;
    private Player p;
    /**
     * Default constructor for objects of class OverlordFrame
     */
    public OverlordFrame()
    {
        p = new Player();
        invPanel = new InventoryPanel(p.getTopInv(), p.getMainInv());
        statPanel = new PlayerStatsPanel(p);
        monstPanel = new MonsterPanel(p);
        buttonPanel = new ButtonPanel(monstPanel, p);
        infPanel = new InformationPanel();
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.ipadx = 100;
        gbc.ipady = 100;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(invPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 0.4;
        gbc.weighty = 0.5;
        add(monstPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        add(statPanel, gbc);
        
        gbc.gridy = 0;
        add(infPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonPanel, gbc);
    
       
         this.setSize(1490, 830);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
    }
    
    public void update()
    {
        statPanel.update(p);
        System.out.println(invPanel.getItem("top", 0));
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        OverlordFrame frame = new OverlordFrame();
        
        while(true)
        {
            frame.update();
            Thread.sleep(100);
        }
    }

}

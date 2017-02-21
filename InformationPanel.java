import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;

/**
 * Write a description of class InformationPanel here.
 * 
 * @author Jay Rixie 
 * @version 2/21/17
 */
public class InformationPanel extends JPanel
{
    JTextArea information;
    public InformationPanel()
    {
        information = new JTextArea("Information", 45, 45);
        
        this.add(information);
    }
}

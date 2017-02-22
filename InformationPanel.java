import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JScrollPane;

/**
 * Write a description of class InformationPanel here.
 * 
 * @author Jay Rixie 
 * @version 2/21/17
 */
public class InformationPanel extends JPanel
{
    public static JTextArea information;
    public JScrollPane scroll;
    public InformationPanel()
    {
        information = new JTextArea("Information", 45, 45);
        scroll = new JScrollPane(information);
        
        this.add(scroll);
    }
    
    public static void update(String input)
    {
        information.append(input);
        information.setRows(45);
        
    }
}

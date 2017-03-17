import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;


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
        information = new JTextArea("Information", 20, 40);
        scroll = new JScrollPane(information);
        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.add(scroll);
    }
    
    public static void update(String input)
    {
        information.append(input);
        information.setRows(20);
        
        //http://stackoverflow.com/questions/9000649/automatically-scroll-to-the-bottom-of-a-text-area
        information.setCaretPosition(information.getDocument().getLength());
    }
}

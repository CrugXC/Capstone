import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Write a description of class Combat here.
 * 
 * @author Jay Rixie
 * @version 
 */
public class Combat
{
    private Player p;
    private MonsterSprite m;
    private MonsterPanel mp;
    
    //true is Player's turn, false is Monster's turn
    private boolean turn;
    
    private boolean action;
    
    private boolean pDead;
    
    private Random r1;
    
    public Combat(Player p1, MonsterPanel mp1)
    {
        p = p1;
        m = null;
        mp = mp1;
        
        pDead = p1.dead();
        
        action = false;
        
        r1 = new Random();
    }
    
    public void startCombat(MonsterSprite m1)
    {
        m = m1;
        turn = p.getAttrib().get("dexterity") > m.getAttrib().get("dexterity");
        action = true;
        
        System.out.println("Combat Started");
    }
    
    public boolean isCombat()
    {
        return action;
    }
    
    public boolean getTurn()
    {
        return turn;
    }
    
    public void attack()
    {
        if(turn)
        {
            p.attack(m);
            if(!m.dead())
            {
                m.attack(p);
            }
            
            if(p.dead() || m.dead())
            {
                this.endCombat();
                InformationPanel.update("\nThe creature is dead!");
            }
            turn = false;
        }
        else
        {
            m.attack(p);
            if(!p.dead())
            {
                p.attack(m);
            }
            
            
            if(m.dead() || p.dead())
            {
                this.endCombat();
                InformationPanel.update("\nThe creature is dead!");
            }
            turn = true;
        }
        mp.update();
    }
    
    public void run()
    {
        if(r1.nextInt(100) > 30)
        {
            this.endCombat();
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,
            "You failed to run away.");
        }
    }
    
    public boolean endCombat()
    {
        action = false;
        mp.deleteMonster();
        
        return pDead;
    }
}

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
    
    private Random r1;
    
    public Combat(Player p1, MonsterPanel mp1)
    {
        p = p1;
        m = null;
        mp = mp1;
        
        
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
            
            else
            {
                this.endCombat();
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
            
            else
            {
                this.endCombat();
            }
            turn = true;
        }
    }
    
    public void run()
    {
        if(r1.nextInt(100) > 60)
        {
            this.endCombat();
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,
            "You failed to run away.");
        }
    }
    
    public void endCombat()
    {
        action = false;
        mp.deleteMonster();
    }
}

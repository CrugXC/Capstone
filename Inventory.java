import java.util.ArrayList;
import java.util.HashMap;
/**
 * Write a description of class Inventory here.
 * 
 * @author Jay Rixie
 * @version (a version number or a date)
 */
public class Inventory
{
    // instance variables - replace the example below with your own
    private ArrayList<ItemSprite> inv;

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        inv = new ArrayList<ItemSprite>(45);
        
        for(int i = 0; i < 45; i++)
        {
            inv.add(null);
        }
        inv.add(new Weapon(new AttackType("Slash", new Range(1,3)), "Basic Wooden Sword", this.hashMapInitializer(1,1,1,1,1,1), null));
        
    }
    
    public static HashMap<String, Integer> hashMapInitializer(int str, int dex, int con, int intel, int wis, int cha)
    {
        HashMap<String, Integer> attrib = new HashMap<String, Integer>();
        
        attrib.put("strength", str);
        attrib.put("dexterity", dex);
        attrib.put("constitution", con);
        attrib.put("intelligence", intel);
        attrib.put("wisdom", wis);
        attrib.put("charisma", cha);
        
        return attrib;
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
        
        for(ItemSprite item: inv)
        {
            
            //iterates through sAtts and counts their attributes
            if(item != null)
            {
                sAtt = item.getAttrib();
                
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
    
    public boolean addItem(ItemSprite item, int space)
    {
        if (inv.get(space) == null)
        {  
            inv.add(space, item);
            return true;
        }
        
        return false;
    }
    
    public ItemSprite getItem(int space)
    {
        return inv.get(space);
    }
    
    public void deleteItem(int space)
    {
        inv.remove(space);
    }
}

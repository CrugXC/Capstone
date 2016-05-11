import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
* Write a description of class WeaponGenerator here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Generator
{
    public static Weapon generateWeapon(int playerLevel)
    {
        Random r1 = new Random();
        return new Weapon(new AttackType(Generator.attackNameGenerator(), new Range(r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3) + playerLevel *3)), "placeholder", Generator.hashMapInitializer(r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3), r1.nextInt(playerLevel * 3)), null);  
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
    
    public static HashMap<Integer, AttackType> attackHashMapInitializer(AttackType a1)
    {
        HashMap<Integer, AttackType> attacks = new HashMap<Integer, AttackType>();
        attacks.put(1, a1);
        
        return attacks;
    }
    
    public static String attackNameGenerator()
    {
        ArrayList<String> modifier = new ArrayList<String>();
        
        modifier.add("Frozen");
        modifier.add("Ice");
        modifier.add("Magma");
        modifier.add("Strong");
        modifier.add("Powerful");
        modifier.add("Explosive");
        modifier.add("Shadow");
        modifier.add("Dark");
        modifier.add("Shattered");
        modifier.add("Monstrous");
        modifier.add("Glorious");
        modifier.add("Fast");
        modifier.add("Slow");
        
        ArrayList<String> attack = new ArrayList<String>();
        attack.add("Swing");
        attack.add("Slash");
        attack.add("Bash");
        attack.add("Shot");
        attack.add("Cut");
        attack.add("Attack");
        
        Random r1 = new Random();
        
        return modifier.get(r1.nextInt(modifier.size())) + " " + attack.get(r1.nextInt(attack.size()));
    }
    
    public static BufferedImage crop(BufferedImage img, Rectangle rect)
    {
        //http://stackoverflow.com/questions/2386064/how-do-i-crop-an-image-in-java
        return img.getSubimage(0, 0, rect.width, rect.height);
    }
    
    public static MonsterSprite generateMonster()
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Monster.png"));
        } catch (IOException e){}
        
        return new MonsterSprite(img, "Goblin", hashMapInitializer(1,1,1,1,1,1), attackHashMapInitializer(new AttackType("Slash", new Range(1, 3))));
    }
}
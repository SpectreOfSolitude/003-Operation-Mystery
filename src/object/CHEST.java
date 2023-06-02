package object;

import javax.imageio.ImageIO;

public class CHEST extends SuperObject
{
    public CHEST()
    {
        name = "Chest";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
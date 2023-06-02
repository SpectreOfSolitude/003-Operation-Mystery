package object;

import javax.imageio.ImageIO;

public class BOOTS extends SuperObject
{
    public BOOTS()
    {
        name = "Boots";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/boots.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
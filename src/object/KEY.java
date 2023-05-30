package object;

import javax.imageio.ImageIO;

public class KEY extends SuperObject
{
    public KEY()
    {
        name = "Key";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

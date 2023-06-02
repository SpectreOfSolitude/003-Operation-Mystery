package object;

import javax.imageio.ImageIO;

public class DOOR extends SuperObject
{
    public DOOR()
    {
        name = "Door";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        collision = true;
    }
}
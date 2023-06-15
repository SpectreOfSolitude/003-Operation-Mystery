package object;

import javax.imageio.ImageIO;

public class IRONDOOR extends SuperObject
{
    public IRONDOOR()
    {
        name = "Door";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_iron.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        collision = true;
    }
}
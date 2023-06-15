package entity;

import main.GamePanel;

public class Yuki extends Entity
{
    public Yuki(GamePanel gp)
    {
        super(gp);

        direction = "down";
        speed = 1;
        
    }
}

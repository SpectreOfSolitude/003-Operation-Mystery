package main;

import entity.yuki;
import object.BAJU;
//import object.BOOTS;
import object.CHEST;
import object.DOOR;
import object.GELANG;
//import object.KEY;
import object.PISAU;

public class ObjectPlacement 
{
    GamePanel gp;

    public ObjectPlacement(GamePanel gp)
    {
        this.gp = gp;
    }    

    public void setObject()
    {
        gp.obj[0] = new GELANG(gp);
        gp.obj[0].worldX = 23 *gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new BAJU(gp);
        gp.obj[1].worldX = 23 *gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new PISAU(gp);
        gp.obj[2].worldX = 37 *gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        gp.obj[3] = new DOOR();
        gp.obj[3].worldX = 10 *gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        gp.obj[4] = new DOOR();
        gp.obj[4].worldX = 8 *gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new DOOR();
        gp.obj[5].worldX = 12 *gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new CHEST();
        gp.obj[6].worldX = 10 *gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;
    }

    public void setNPC()
    {
        gp.npc[0] = new yuki(gp);
        gp.npc[0].worldX = 21*gp.tileSize;
        gp.npc[0].worldY = 21*gp.tileSize;
    }
}

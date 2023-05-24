package main;

import entity.Entity;

public class CollisionChecker 
{
    GamePanel gp;

    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;

    }    

    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.WorldX + entity.SolidArea.x;
        int entityRightWorldX = entity.WorldX + entity.SolidArea.x + entity.SolidArea.width;
        int entityTopWorldY = entity.WorldY + entity.SolidArea.y;
        int entityBottomWorldY= entity.WorldY + entity.SolidArea.y + entity.SolidArea.height;

        int entityLeftHorizontal = entityLeftWorldX/gp.tileSize;
        int entityRightHorizontal = entityRightWorldX/gp.tileSize;
        int entityTopVertical = entityTopWorldY/gp.tileSize;
        int entityBottomVertical = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) 
        {
            case "up":
                entityTopVertical = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftHorizontal][entityTopVertical];
                tileNum2 = gp.tileM.mapTileNum[entityRightHorizontal][entityTopVertical];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomVertical = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftHorizontal][entityBottomVertical];
                tileNum2 = gp.tileM.mapTileNum[entityRightHorizontal][entityBottomVertical];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftHorizontal = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftHorizontal][entityTopVertical];
                tileNum2 = gp.tileM.mapTileNum[entityLeftHorizontal][entityBottomVertical];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightHorizontal = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightHorizontal][entityTopVertical];
                tileNum2 = gp.tileM.mapTileNum[entityRightHorizontal][entityBottomVertical];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
        
            default:
                break;
        }
    }
}

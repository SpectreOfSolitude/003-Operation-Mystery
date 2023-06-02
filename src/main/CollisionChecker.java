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
        }
    }
    public int checkObject(Entity entity, boolean player)
    {
      int index = 999;
      
      for(int i=0; i < gp.obj.length; i++)
      {
        if(gp.obj[i] != null)
        {
            // Get Entity's Solid Area Position
            entity.SolidArea.x = entity.WorldX + entity.SolidArea.x;
            entity.SolidArea.y = entity.WorldY + entity.SolidArea.y;
            // Get the Object's Solid Area Position
            {
                gp.obj[i].SolidArea.x = gp.obj[i].worldX + gp.obj[i].SolidArea.x;
                gp.obj[i].SolidArea.y = gp.obj[i].worldY + gp.obj[i].SolidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.SolidArea.y = entity.SolidArea.y - entity.speed;
                        if(entity.SolidArea.intersects(gp.obj[i].SolidArea))
                        {
                            if(gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }

                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.SolidArea.y = entity.SolidArea.y + entity.speed;
                        if(entity.SolidArea.intersects(gp.obj[i].SolidArea))
                        {
                            if(gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }

                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.SolidArea.x = entity.SolidArea.x - entity.speed;
                        if(entity.SolidArea.intersects(gp.obj[i].SolidArea))
                        {
                            if(gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.SolidArea.x = entity.SolidArea.x + entity.speed;
                        if(entity.SolidArea.intersects(gp.obj[i].SolidArea))
                        {
                            if(gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                }
            }
            entity.SolidArea.x = entity.SolidAreaDefaultX;
            entity.SolidArea.y = entity.SolidAreaDefaultY;
            gp.obj[i].SolidArea.x = gp.obj[i].SolidAreaDefaultX;
            gp.obj[i].SolidArea.y = gp.obj[i].SolidAreaDefaultY;
        }
      }

      return index;
    }
}

package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity
{
    public int WorldX, WorldY;
    public int speed;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle SolidArea;
    public int SolidAreaDefaultX, SolidAreaDefaultY;
    public boolean collisionOn = false;
}
// -- Chara -- //
// Raden Wijaya
// Jayakatwang
// Arya Wiraradja
// Kertanegara
// Ken Suro
// Tribuana
// Khubilai Khan
// Meiking

// -- Latar -- //
// Kerajaan Singosari
// Hutan Triwulan (Tempat majapahit ditemukan)
// Rawa-rawa dan sungai (Pertemuan Yuan dengan Raden Wijaya)
// Tiongkok China (Mostly Cutscenes)
// Tempat Adipati Madura

// -- Skin Graphics Model -- //
// Prajurit Tani
// Prajurit Professional
// Prajurit Elite

// -- Cutscenes -- //
// Upacara Tantra (Terbunuhnya Kertanegara di tangan Jayakatwang)
// 

// -- Voicelines -- //
// Arya Wiraradja -> Akmal 21
// Kertanegara -> Reyner 21
// Tribhuana -> Ana 22
// Gyatri -> Amanda 22
// Ken Sora -> Reva 21
// Khubilai Khan -> Geo 21
// Mei-qing -> Abet 21
// Jendral Yuan -> Baruna 22
// Jayakatwang -> Ari 21
// Raden Wijaya -> Akasyah 21


package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class BAJU extends SuperObject
{
    GamePanel gp;

    public BAJU(GamePanel gp)
    {
        this.gp = gp;
        name = "Baju";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/boots.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        setMonologue();
    }

    public void setMonologue()
    {
        monologues[0] = "Ada apa ini? Tadi \ncincin, sekarang baju...";
	    monologues[1] = "Perasaan ini lagi...\nhaduh. Rasa yang menjijikan apa ini?";
	    monologues[2] = "Rasanya seperti aku \nmembenci diriku sendiri...";
	    monologues[3] = "Tidak seperti biasanya...";
	    monologues[4] = "hm? Tulisan apa itu?";
        monologues[5] = "'MY BEST BOYFRIEND'?";
        monologues[6] = "AHAHAHAAHAHA";
        monologues[7] = "Ahh... buang-buang waktu aja.";
        monologues[8] = "Duh, aku mencari apa ya\ntadi?";

    }

    public void setAction()
    {
        actionLockCounter ++;
    }

    public void monologue()
    {
        if(monologues[monologueIndex] == null)
        {
            monologueIndex = 0;
        }

        gp.ui.currentDialogue = monologues[monologueIndex];
        monologueIndex++;
    }

}
